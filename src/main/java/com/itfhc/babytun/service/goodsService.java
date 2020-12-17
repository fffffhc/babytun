package com.itfhc.babytun.service;

import com.itfhc.babytun.dao.*;
import com.itfhc.babytun.entity.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/9 18:36
 */

@Service
public class goodsService {

    @Resource
    private goodsDao gd;
    @Resource
    private goodsCoverDao gcd;
    @Resource
    private goodsDetailDao gdd;
    @Resource
    private goodsParamDao gpd;
    @Resource
    private evaluateDao ed;

    //cacheable是
    //第一次访问的时候将返回的结果放入缓存
    //第二次访问时不再访问方法内部的代码，从缓存中直接提取数据
    @Cacheable(value = "goods",key = "#goodsId")
    public goods getGoodsById(Long goodsId){
        return gd.findById(goodsId);
    }

    @Cacheable(value = "covers",key = "#goodsId")
    public List<goodsCover> getCoverById(Long goodsId){
        return gcd.findCoverById(goodsId);
    }

    @Cacheable(value = "details",key = "#goodsId")
    public List<goodsDetail> getDetailById(Long goodsId){ return gdd.findDetailById(goodsId);}

    @Cacheable(value = "params",key = "#goodsId")
    public List<goodsParam> getParamById(Long goodsId){ return gpd.findParamById(goodsId);}

    public List<goods> findall(){ return gd.findall();}

    public List<goods> findLast5Min(){ return gd.findLast5Min();}

    public List<evaluate> findByGoodsId(Long goodsId){ return ed.findByGoodsId(goodsId);}
}
