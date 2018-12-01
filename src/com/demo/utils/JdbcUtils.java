package com.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by ForMe
 * com.demo
 * 2018/12/1
 * 15:31
 */
public class JdbcUtils {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String dv = null;

    static{
        Properties prop = new Properties();
        InputStream in = JdbcUtils.class.getResourceAsStream("/a");

        try {
            prop.load(in);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            dv = prop.getProperty("driver");

            //注册驱动
            Class.forName(dv);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getconn() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;

    }

    public static void close(Statement statement, Connection connection){
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement, Connection connection, ResultSet result) {
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(result != null){
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
