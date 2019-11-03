package com.qf.service.impl;

import com.qf.dao.ShopPicMapper;
import com.qf.domain.ShopPic;
import com.qf.service.ShopPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 54110 on 2019-05-27.
 */
@Service
public class ShopPicServiceImpl implements ShopPicService {

    @Autowired
    private ShopPicMapper shopPicMapper;

    @Override
    public List<ShopPic> selectAll(ShopPic shopPic) {


        return  shopPicMapper.selectAll(shopPic);
    }

    @Override
    public int selectUserCount() {
        return shopPicMapper.selectCount();
    }

    @Override
    public void updateStatus(ShopPic shopPic) {
        shopPicMapper.updateByPrimaryKeySelective(shopPic);
    }
}
