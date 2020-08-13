package com.chinasoft.um.service.impl;

import com.chinasoft.um.dao.UserDao;
import com.chinasoft.um.model.User;
import com.chinasoft.um.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDao();

    /**
     *  查询所有用户
     * @return
     */
    @Override
    public List<User> findAllUsers() {
        return dao.findAll();
    }

    /**
     * 用户登录
     * @return
     */
    @Override
    public User loginUser(User loginUser) {
        return dao.findUserByNameAndPassWord(loginUser);
    }

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User findOne(Integer id) {
        return dao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }


}
