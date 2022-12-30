package org.example.connection;

import java.sql.*;

public class SqlConnection {
    public Connection connectMysql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_db",
                                                               "root", "1234");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
