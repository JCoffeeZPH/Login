package com.demo.dao;

import com.demo.bean.User;
import com.demo.utils.JdbcUtils;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by ForMe
 * com.demo
 * 2018/12/1
 * 15:59
 */
public class UserDAo {
    //数据库连接对象
    //此方法用于在数据库中查询信息并与Login.jsp表格中所填信息比较，若数据库中存在
    //与表格所填数据一一对应相等，则登陆成功，否则登录失败
    public User login(String username, String password){
        User u = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getconn();
            String sql = "select * from user where name=? and password=?";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                u = new User();
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                System.out.println("登录成功");
            }
            else{
                System.out.println("用户名或者密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JdbcUtils.close(preparedStatement,connection);
        }
            return u;
    }

    //此方法实现注册功能，向数据库中写入新用户的信息
    public void addUser(User user){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "insert into user(id,name,password,role)values(?,?,?,?);";
            preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.close(preparedStatement,connection);
        }

    }

}
