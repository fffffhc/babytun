package com.itfhc.babytun.dao;

import com.itfhc.babytun.entity.goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/9 18:21
 */
@Mapper
public interface goodsDao {
    public goods findById(Long goodsId);
    public List<goods> findall();
    public List<goods> findLast5Min();
}
