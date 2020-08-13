package com.chinasoft.um.dao;

import com.chinasoft.um.model.User;
import com.chinasoft.um.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询用户列表
     * @return
     */
    public List<User> findAll(){
        try {
            String sql = "select * from t_user";
            List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
            return list;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 通过用户名和密码查询用户
     * @param loginUser
     * @return
     */
    public User findUserByNameAndPassWord(User loginUser){
        try {
            String sql = "select * from t_user where username=? and password=?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),loginUser.getUsername(),loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 新增用户
     * @param user
     */
    public void addUser(User user){
        String sql = "insert into t_user values(null,?,?,?,?,?,?,null)";
        template.update(sql,user.getUsername(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }


    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user){
        String sql = "update t_user set username=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getUsername(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findUserById(Integer id){
        try {
            String sql = "select * from t_user where id = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }













}
