package com.itfhc.babytun.dao;

import com.itfhc.babytun.entity.goodsCover;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author FUHAOCHENG
 * @version 1.0
 * @date 2020/12/10 17:41
 */
@Mapper
public interface goodsCoverDao {
    public List<goodsCover> findCoverById(Long gooodsid);
}
