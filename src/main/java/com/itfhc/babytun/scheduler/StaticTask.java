package com.itfhc.babytun.scheduler;

import com.itfhc.babytun.entity.goods;
import com.itfhc.babytun.service.goodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/15 18:16
 */
@Component//组件类，ioc容器扫描到后自动实例化加载
public class StaticTask {
    @Resource
    private goodsService goodsService;
    @Resource
    private Configuration configuration;

    //* * * * * ?每秒钟执行一次
    //秒 分 小时 日 月 星期
    //0 * * * * ? 每分钟0秒时执行
    @Scheduled(cron = "0 0/5 * * * ?")
    public void dostatic() throws IOException, TemplateException {
        Template template = configuration.getTemplate("goods.ftl");
        List<goods> allgoods = goodsService.findLast5Min();
        for (goods g : allgoods){
            Long id = g.getGoodsId();
            Map param = new HashMap<>();
            param.put("goods",goodsService.getGoodsById(id));
            param.put("cover",goodsService.getCoverById(id));
            param.put("detail",goodsService.getDetailById(id));
            param.put("param",goodsService.getParamById(id));

            File targetFile = new File("d:/babytun/goods/" + id + ".html");
            FileWriter out = new FileWriter(targetFile);
            template.process(param,out);
            System.out.println(new Date() +":"+ targetFile + "文件已生成");
            out.close();
        }
    }
}
