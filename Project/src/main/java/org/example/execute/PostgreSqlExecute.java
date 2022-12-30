package org.example.execute;

import org.example.connection.PostgreSqlConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Scanner;

public class PostgreSqlExecute {

    Logger log = LoggerFactory.getLogger(PostgreSqlExecute.class);

    public ResultSet ExecutePostgresQuery() throws SQLException {
        PostgreSqlConnection postgres = new PostgreSqlConnection();
        Connection postgresConnection = postgres.connectPostgres();
        Scanner scanner = new Scanner(System.in);
        PreparedStatement pstmt = null;
        Statement stmt = null;

        ResultSet rs = postgresConnection.prepareStatement("select * from EMPLOYEE1 where empid=1 ")
                .executeQuery();
        return rs;
    }
}