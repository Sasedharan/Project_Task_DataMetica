package org.example.execute;

import org.example.connection.SqlConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Scanner;

public class MysqlExecute {
    Logger log = LoggerFactory.getLogger(MysqlExecute.class);

    public ResultSet ExecuteMysqlQuery() throws SQLException {
        SqlConnection mysql = new SqlConnection();
        Connection mysqlConnection = mysql.connectMysql();
        Scanner scanner = new Scanner(System.in);

        String query = "select * from employee1 where empid = 1";

        ResultSet rs = mysqlConnection.prepareStatement(query).executeQuery();
        return rs;

        /*System.out.println("enter the empid to compare");
        int value = scanner.nextInt();
            if (value <= ) {
                pstmt.setInt(1, value);
            } else{
                System.out.println("Row not present");
            }
            pstmt = mysqlConnection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            return rs;*/
    }
}