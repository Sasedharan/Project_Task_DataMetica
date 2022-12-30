package org.example.execute;

import org.example.connection.SqlConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class MysqlExecute {
    Logger log = LoggerFactory.getLogger(MysqlExecute.class);

    public ResultSet ExecuteMysqlQuery() throws SQLException {
        SqlConnection mysql = new SqlConnection();
        Connection mysqlConnection = mysql.connectMysql();
        Scanner scanner = new Scanner(System.in);
        PreparedStatement pstmt = null;

        ResultSet rs = mysqlConnection.prepareStatement("select * from EMPLOYEE2 where  empid=1 ")
                .executeQuery();
        return rs;
    }
}
