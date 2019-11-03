package com.qf.service.impl;

import com.qf.dao.UserMapper;
import com.qf.domain.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 54110 on 2019-05-26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByLoginName(String name) {
        User user = userMapper.selectUserByLoginName(name);
        return user;
    }

    @Override
    public int insertUser(User user) {
        user.setCreateTime(new Date());
        if (user.getStatus()==null){
            user.setStatus("1");
        }

        return userMapper.insert(user);
    }

    @Override
    public List<User> selectAll(User user) {
        return userMapper.selectAll(user);
    }

    @Override
    public int selectUserCount() {
        return userMapper.selectCount();
    }

    @Override
    public void updateUser(User userInfo) {
        userInfo.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
