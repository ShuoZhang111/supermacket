package com.shuo.supermacket.member.controller;

import com.shuo.supermacket.member.domain.Jackson;
import com.shuo.supermacket.member.domain.Result;
import com.shuo.supermacket.member.domain.SqlConnection;
import com.shuo.supermacket.member.model.LoginModel;
import com.shuo.supermacket.member.service.LoginService;
import com.shuo.supermacket.member.utils.ResultUtil;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.jar.JarEntry;

public class LoginController extends HttpServlet {
    private Statement statement = null;
    private Connection connection = null;
    private LoginModel adminModel;

    private Result result;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            connection = SqlConnection.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admin_user");
            while (resultSet.next()) {
                adminModel = new LoginModel();
                adminModel.setName(resultSet.getString("name"));
                adminModel.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String json = Jackson.toJson(ResultUtil.success(adminModel));

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LoginModel loginModel = new LoginModel();
        LoginService loginService = new LoginService();
        PrintWriter out = response.getWriter();

        loginModel.setName(request.getParameter("name"));
        System.out.println(request.getParameter("name"));
        loginModel.setPassword(request.getParameter("password"));

        try {
            if (loginService.adminLogin(loginModel)) {

                result = ResultUtil.success();
                out.println(Jackson.toJson(result));
                HttpSession session = request.getSession();
                session.setAttribute("isLogin",true);

            } else {

                result = ResultUtil.error(0, "login is false");
                out.println(Jackson.toJson(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
