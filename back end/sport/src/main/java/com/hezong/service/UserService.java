package com.hezong.service;

import com.hezong.pojo.User;

import java.util.List;

/**
 * 用户业务层实现接口
 */

public interface UserService {
    //根据用户名和密码获取信息
    User getUserByMessage(String username, String password);

    //获取所有用户  pageStart:从哪里开始展示  pageSize：页面展示条数
    List<User> getAllUser(String username, int pageStart, int pageSize);

    //获取所有用户的个数
    int getUserCounts(String username);

    //更新用户状态
    int updateState(Integer id,Boolean state);

    //添加用户的方法
    int addUser(User user);

    //删除用户的方法
    int deleteUser(int id);

    //修改用户的方法
    User getUpdateUser(int id);//根据id查询出用户
    int editUser(User user);//根据查询出的用户进行修改
}
