package com.qf.service;

import com.qf.domain.User;

import java.util.List;

/**
 * Created by 54110 on 2019-05-26.
 */
public interface UserService {
    User selectUserByLoginName(String name);
    int insertUser(User user);

    List<User> selectAll(User user);

    int selectUserCount();

    void updateUser(User userInfo);

    User selectUserById(int id);

    void deleteUser(int id);
}
