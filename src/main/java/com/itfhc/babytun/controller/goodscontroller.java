package com.itfhc.babytun.controller;


import com.itfhc.babytun.entity.goods;
import com.itfhc.babytun.service.goodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/9 13:32
 */

@RestController
public class goodscontroller {
     Logger logger = LoggerFactory.getLogger(goodscontroller.class);

    @Resource
    private goodsService goodsService;

    //Freemarker核心配置类，用于动态生成模板对象
    @Resource
    private Configuration configuration;

    @GetMapping("/goods")
    public ModelAndView showGoods(Long id){

        logger.info("gid:" + id);

        ModelAndView mv = new ModelAndView("/goods");
        goods goods = goodsService.getGoodsById(id);
        mv.addObject("goods",goods);
        mv.addObject("cover",goodsService.getCoverById(id));
        mv.addObject("detail",goodsService.getDetailById(id));
        mv.addObject("param",goodsService.getParamById(id));
        return mv;
    }

    @GetMapping("/static/{gid}")
    @ResponseBody
    public String doStatic(@PathVariable("gid") Long id) throws IOException, TemplateException {
        //获取模板对象
        Template template = configuration.getTemplate("goods.ftl");
        Map param = new HashMap<>();
        param.put("goods",goodsService.getGoodsById(id));
        param.put("cover",goodsService.getCoverById(id));
        param.put("detail",goodsService.getDetailById(id));
        param.put("param",goodsService.getParamById(id));

        File targetFile = new File("d:/babytun/goods/" + id + ".html");
        FileWriter out = new FileWriter(targetFile);
        template.process(param,out);
        out.close();
        return targetFile.getPath();
    }

    @GetMapping("/static_all")
    @ResponseBody
    public String doStatic() throws IOException, TemplateException {
        Template template = configuration.getTemplate("goods.ftl");
        List<goods> allgoods = goodsService.findall();
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
            out.close();
        }
        return "ok";

    }


}
