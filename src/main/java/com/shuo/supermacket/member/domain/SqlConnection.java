package com.shuo.supermacket.member.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    private static final String url = "jdbc:mysql://localhost:3306/member";
    private static final String user = "root";
    private static final String password = "123456";
    private static Connection connection = null;

    static {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return Connection
     */
    public static Connection getConnection() {
        return connection;
    }
}
