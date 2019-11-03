package com.qf.service.impl;

import com.qf.dao.GoodsMapper;
import com.qf.domain.Goods;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceIMpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> selectAll(Goods goods) {
        return   goodsMapper.selectAll(goods);

    }

    @Override
    public Goods selectById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Integer count() {
        return goodsMapper.count();
    }

    @Override
    public int deleteById(Integer id) {
        return goodsMapper.deleteById(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }
}
