package com.qf.service;

import com.qf.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> selectAll(Goods goods);

    Goods selectById(Integer id);

    int insert(Goods goods);

    Integer count();

    int deleteById(Integer id);

    int updateGoods(Goods goods);
}
