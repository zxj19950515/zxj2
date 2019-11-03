package com.qf.service.impl;

import com.qf.dao.ShoperMapper;
import com.qf.domain.Shoper;
import com.qf.service.ShoperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShoperServiceImpl implements ShoperService {

    @Autowired
    private ShoperMapper shoperMapper;

    @Override
    public List<Shoper> selectAll(Shoper shoper) {
        return shoperMapper.selectAll(shoper);
    }

    @Override
    public Shoper selectById(Integer id) {
        return shoperMapper.selectById(id);
    }

    @Override
    public int insert(Shoper shoper) {
        if (shoper.getPosStatus()==null){
            shoper.setPosStatus("1");
        }

        return shoperMapper.insert(shoper);
    }


    @Override
    public Integer count() {
        return shoperMapper.count();
    }

    @Override
    public int deleteById(Integer id) {
        return shoperMapper.deleteById(id);
    }

    @Override
    public int updateUser(Shoper shoper) {
        return shoperMapper.updateShoper(shoper);
    }
}
