package org.example;

import org.example.execute.MysqlExecute;
import org.example.execute.PostgreSqlExecute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Objects;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        logger.info("\n****  CONNECTED TO MYSQL DATABASE  **** ");
        MysqlExecute m = new MysqlExecute();
        ResultSet resultset1 = m.ExecuteMysqlQuery();

        logger.info("\n****  CONNECTED TO POSTGRESQL DATABASE  **** ");
        PostgreSqlExecute p = new PostgreSqlExecute();
        ResultSet resultset2 = p.ExecutePostgresQuery();

        System.out.println("\n___Comparing Mysql and PostgreSql Resultset___");
        System.out.println("------------------------------------------------");
        CompareResultset(resultset1, resultset2);
    }

    public static void CompareResultset(ResultSet resultSet1, ResultSet resultSet2) throws SQLException {
        String comparedResult;
        try {
            ResultSetMetaData rsmd1 = resultSet1.getMetaData();
            ResultSetMetaData rsmd2 = resultSet2.getMetaData();
            int rsColumn1 = rsmd1.getColumnCount();
            int rsColumn2 = rsmd2.getColumnCount();
            if (rsColumn1 == rsColumn2) {
                while (resultSet1.next() && resultSet2.next()) {
                    for (int columCount = 1; columCount <= rsColumn1; columCount++) {
                        int columnType = rsmd1.getColumnType(columCount);
                        if (columnType == Types.INTEGER || columnType == Types.BIGINT || columnType == Types.NUMERIC ||
                                columnType == Types.SMALLINT) {
                            Long colValue1 = resultSet1.getLong(columCount);
                            Long colValue2 = resultSet2.getLong(columCount);
                            if (!colValue1.equals(colValue2)) {
                                comparedResult = "Data MisMatch Found in Column - " + columCount + " of value " + "'" +
                                        colValue1 + "'" + " with " + "'" + colValue2 + "'";
                                System.out.println(comparedResult);
                            }
                        } else if (columnType == Types.CHAR || columnType == Types.LONGVARCHAR ||
                                columnType == Types.VARCHAR) {
                            String colValue1 = resultSet1.getString(columCount);
                            String colValue2 = resultSet2.getString(columCount);
                            if (!Objects.equals(colValue1, colValue2)) {
                                comparedResult = "Data MisMatch Found in Column - " + columCount + " of value " +
                                        "'" + colValue1 +
                                        "'" + " with " + "'" + colValue2 + "'";
                                System.out.println(comparedResult);
                            }
                        } else if (columnType == Types.DECIMAL || columnType == Types.FLOAT || columnType == Types.DOUBLE
                                || columnType == Types.REAL) {
                            Double colValue1 = resultSet1.getDouble(columCount);
                            Double colValue2 = resultSet2.getDouble(columCount);
                            if (!colValue1.equals(colValue2)) {
                                comparedResult = "Data MisMatch Found in Column - " + columCount + " of value " + "'"
                                        + colValue1 +
                                        "'" + " with " + "'" + colValue2 + "'";
                                System.out.println(comparedResult);
                            }
                        } else if (columnType == Types.DATE || columnType == Types.TIME || columnType == Types.TIMESTAMP) {
                            Timestamp colValue1 = resultSet1.getTimestamp(columCount);
                            Timestamp colValue2 = resultSet2.getTimestamp(columCount);
                            if (colValue1 != colValue2) {
                                comparedResult = "Data MisMatch Found in Column - " + columCount + " of value " + "'" +
                                        colValue1 + "'" + " with " + "'" + colValue2 + "'";
                                System.out.println(comparedResult);
                            }
                        }
                    }
                }
                System.out.println("Data Matches in both Table");
            } else {
                comparedResult = "Column Mismatch Found : " + "\n\tNo of Column in First Table : " +
                        rsColumn1 + "\n\tNo of Column in Second Table : " + rsColumn2;
                System.out.println(comparedResult);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}


