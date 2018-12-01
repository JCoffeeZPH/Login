package com.demo.service;

import com.demo.bean.User;
import com.demo.dao.UserDAo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ForMe
 * ${PACKAGE_NAME}
 * 2018/12/1
 * 16:28
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPut(request,response);
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
    protected  void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        //PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        int role = Integer.valueOf(request.getParameter("role"));

        User user = new User();
        user.setId(id);
        user.setName(username);
        user.setPassword(password);
        user.setRole(role);
        UserDAo userDAo = new UserDAo();
        userDAo.addUser(user);
        System.out.println("注册成功");
        request.getRequestDispatcher("Login.jsp").forward(request,response);
    }
}
