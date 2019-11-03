package com.qf.dao;

import com.qf.domain.Shoper;

import java.util.List;

public interface ShoperMapper {
    Shoper selectById(Integer id);

    List<Shoper> selectAll(Shoper shoper);

    Integer count();

    int insert(Shoper shoper);

    int deleteById(Integer id);

    int updateShoper(Shoper shoper);
}
