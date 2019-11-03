package com.qf.dao;

import com.qf.domain.Goods;

import java.util.List;

public interface GoodsMapper {
    Goods selectById(Integer id);

    List<Goods> selectAll(Goods goods);

    Integer count();

    int insert(Goods goods);

    int deleteById(Integer id);

    int updateGoods(Goods goods);
}
