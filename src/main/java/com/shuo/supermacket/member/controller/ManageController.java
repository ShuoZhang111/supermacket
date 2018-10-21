package com.shuo.supermacket.member.controller;

import com.shuo.supermacket.member.domain.Jackson;
import com.shuo.supermacket.member.service.ManageService;
import com.shuo.supermacket.member.utils.ResultUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageController extends HttpServlet {

    ManageService manageService;
    ArrayList list;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        manageService = new ManageService();
        try {
            list = manageService.getMemberUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String json = Jackson.toJson(ResultUtil.success(list));
        out.println(json);
    }
}
