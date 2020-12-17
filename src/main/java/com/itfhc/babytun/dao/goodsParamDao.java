package com.itfhc.babytun.dao;

import com.itfhc.babytun.entity.goodsParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/10 18:25
 */

@Mapper
public interface goodsParamDao {
    public List<goodsParam> findParamById(Long gooodsid);
}
