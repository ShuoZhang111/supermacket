package com.shuo.supermacket.member.service;

import com.shuo.supermacket.member.domain.SqlConnection;
import com.shuo.supermacket.member.model.MemberUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ManageService {

    public List<MemberUser> getMemberUser() throws SQLException {
        List<MemberUser> list = null;
        Connection connection = SqlConnection.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM member_user");
        while (resultSet.next()) {

        }

        return list;
    }
}
