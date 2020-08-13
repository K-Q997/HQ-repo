package com.chinasoft.um.service;

import com.chinasoft.um.model.User;

import java.util.List;

public interface UserService {

    /**
     *  查询所有用户
     * @return 用户列表
     */
    List<User> findAllUsers();

    /**
     *  用户登录
     * @param loginUser
     * @return
     */
    User loginUser(User loginUser);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findOne(Integer id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

}
