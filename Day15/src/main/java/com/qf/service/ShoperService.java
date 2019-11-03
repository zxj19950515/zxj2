package com.qf.service;

import com.qf.domain.Shoper;

import java.util.List;

public interface ShoperService {
    List<Shoper> selectAll(Shoper shoper);

    Shoper selectById(Integer id);

    int insert(Shoper shoper);

    Integer count();

    int deleteById(Integer id);

    int updateUser(Shoper shoper);
}

