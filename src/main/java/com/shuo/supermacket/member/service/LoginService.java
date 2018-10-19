package com.shuo.supermacket.member.service;

import com.shuo.supermacket.member.domain.SqlConnection;
import com.shuo.supermacket.member.model.LoginModel;

import java.sql.*;

public class LoginService {

    public boolean adminLogin(LoginModel loginModel) throws SQLException {
        boolean isLogin = false;
        Connection connection = SqlConnection.getConnection();

        String sql = "" +
                "SELECT password FROM admin_user WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, loginModel.getName());

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            if (loginModel.getPassword().equals(resultSet.getString("password"))) {
                isLogin = true;
            }
        }
        return isLogin;
    }

}
