package com.qf.dao;


import com.qf.domain.ShopPic;

import java.util.List;

public interface ShopPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopPic record);

    int insertSelective(ShopPic record);

    ShopPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopPic record);

    int updateByPrimaryKey(ShopPic record);

    List<ShopPic> selectAll(ShopPic shopPic);

    int selectCount();
}