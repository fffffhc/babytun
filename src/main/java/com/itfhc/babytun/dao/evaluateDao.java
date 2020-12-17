package com.itfhc.babytun.dao;

import com.itfhc.babytun.entity.evaluate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/15 19:02
 */
@Mapper
public interface evaluateDao {
    public List<evaluate> findByGoodsId(Long goodsId);
}
