package org.example;

import org.apache.log4j.Logger;
import org.example.execute.MysqlExecute;
import org.example.execute.PostgreSqlExecute;

import java.sql.*;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {

        logger.info("Connected to MySql Database");

        System.out.println("\t\n____*** 1. EXECUTING MYSQL QUERIES ***___\n");
        MysqlExecute m = new MysqlExecute();
        m.ExecuteMysqlQuery();

        logger.info("Postgres - Connected");

        System.out.println("\t\n____*** 2. EXECUTING POSTGRESQL QUERIES ***___\n");
        PostgreSqlExecute p = new PostgreSqlExecute();
        p.ExecutePostgresQuery();
    }
}
