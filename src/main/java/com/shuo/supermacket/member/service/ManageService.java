package com.shuo.supermacket.member.service;

import com.shuo.supermacket.member.domain.SqlConnection;
import com.shuo.supermacket.member.model.MemberUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ManageService {

    public ArrayList getMemberUser() throws SQLException {

        Connection connection = SqlConnection.getConnection();
        ArrayList<MemberUser> list= new ArrayList<>(1000);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM member_user");
        while (resultSet.next()) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUserName(resultSet.getString("user_name"));
            memberUser.setUserPoints(resultSet.getInt("user_points"));
            memberUser.setId(resultSet.getInt("id"));

            list.add(memberUser);
        }

        return list;
    }
}
