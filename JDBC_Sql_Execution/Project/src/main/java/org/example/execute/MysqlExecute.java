package org.example.execute;

import org.example.connection.SqlConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlExecute {

    public void ExecuteMysqlQuery() throws SQLException {
        SqlConnection mysql = new SqlConnection();
        Connection mysqlConnection = mysql.connectMysql();

        System.out.println("Group Concat - Function :");
        ResultSet res = mysqlConnection.prepareStatement("select empcode, GROUP_CONCAT(skill) from EMPLOYEE group by empcode")
                .executeQuery();
        while (res.next()) {
            int empcode = res.getInt(1);
            String skill = res.getString(2);
            System.out.println(empcode + "-" + skill);
        }
        res.close();
        System.out.println("\nROUND_OFF - Function :");
        PreparedStatement preparedStatement1 = mysqlConnection.prepareStatement("select round(?/100,-1.34),round(?/100,1.34)");
        preparedStatement1.setInt(1,12345);
        preparedStatement1.setInt(2,12345);
            ResultSet res1 = preparedStatement1.executeQuery();
            res1.next();
            {
                double r1 = res1.getInt(1);
                double r2 = res1.getDouble(2);
                System.out.println("RoundedValue :" + r1 + " , " + "RoundedValue :" + r2);
            }
            res1.close();
            System.out.println("\nTRUNCATE - Function :");

        PreparedStatement preparedStatement2 = mysqlConnection.prepareStatement("SELECT TRUNCATE(135.375, 1),TRUNCATE(135.375, 5),TRUNCATE(13, 1)");
        ResultSet res2 = preparedStatement2.executeQuery();
            res2.next();
            {
                double r1 = res2.getDouble(1);
                double r2 = res2.getDouble(2);
                double r3 = res2.getDouble(3);
                System.out.println("TruncatedValue:" + r1 + " , " + "TruncatedValue:" + r2 + " , " + "TruncatedValue:" + r3);
            }
        System.out.println("\nSUB_DATE - Function :");
        PreparedStatement preparedStatement3 = mysqlConnection.prepareStatement("SELECT SUBDATE('2022-09-15', INTERVAL 10 DAY); ");
        ResultSet res3 = preparedStatement3.executeQuery();
            res3.next();
                System.out.println("Date: 2022-09-15 --> Resultant Date: " + res3.getDate(1));

        System.out.println("\nTRUNCATE - Function :");
        PreparedStatement preparedStatement4 = mysqlConnection.prepareStatement("SELECT TRUNCATE(32.4567, 2)");
            ResultSet res4 = preparedStatement4.executeQuery();
            res4.next();
                double r4 = res4.getDouble(1);
                System.out.println("TruncateValue 32.4567 --> Resultant Value:" + r4);

        System.out.println("\nLENGTH - Function :");
        PreparedStatement preparedStatement5 = mysqlConnection.prepareStatement("SELECT length(line) from table1");
            ResultSet res5 = preparedStatement5.executeQuery();
            res5.next();
                int r5 = res5.getInt(1);
                System.out.println("Length of the String :" + r5);

        System.out.println("\nSUBSTRING - Function :");
        PreparedStatement preparedStatement6 = mysqlConnection.prepareStatement("SELECT  SUBSTR((line),4,4) from table1");
            ResultSet res6 = preparedStatement6.executeQuery();
            res6.next();
                String r6 = res6.getString(1);
                System.out.println("Sub String :" + r6);

        System.out.println("\nIN_STRING - Function :");
        PreparedStatement preparedStatement7 = mysqlConnection.prepareStatement("SELECT INSTR(line,'W') from table2");
            ResultSet res7 = preparedStatement7.executeQuery();
            res7.next();
                int r7 = res7.getInt(1);
                System.out.println("Match Position of W in String :" + r7);

        System.out.println("\nTIME_TO_SECOND - Function :");
        PreparedStatement preparedStatement8 = mysqlConnection.prepareStatement("SELECT TIME_TO_SEC('13:20:10')");
            ResultSet res8 = preparedStatement8.executeQuery();
            res8.next();
                BigDecimal r8= res8.getBigDecimal(1);
                System.out.println("Time(13:20:10) to Seconds :" + r8);

        System.out.println("\nUNIX_TIME - Function :");
        PreparedStatement preparedStatement9 = mysqlConnection.prepareStatement("SELECT FROM_UNIXTIME(1447430881, '%Y %D %M %h:%i:%s %x')");
            ResultSet res9 = preparedStatement9.executeQuery();
            res9.next();
                String r9 = res9.getString(1);
                System.out.println(r9);

        System.out.println("\nCONCAT - Function :");
        PreparedStatement preparedStatement10 = mysqlConnection.prepareStatement("SELECT CONCAT_WS('-', 'Open', 'Source', 'Relational', 'DBMS')");
            ResultSet res10 = preparedStatement10.executeQuery();
            res10.next();
                String r10 = res10.getString(1);
                System.out.println("ConcatenatedStrings : " + r10);

        System.out.println("\nDAY - Function :");
        PreparedStatement preparedStatement11 = mysqlConnection.prepareStatement("SELECT DAYOFMONTH('2017-06-15')");
            ResultSet res11 = preparedStatement11.executeQuery();
            res11 .next();
                int r11 = res11 .getInt(1);
                System.out.println("Number of Days : " + r11);

        System.out.println("\nREGEX_REPLACE - Function :");
        PreparedStatement preparedStatement12 = mysqlConnection.prepareStatement("select regexp_replace(?,"+"?, ?, 1, 1 )");
            preparedStatement12.setString(1,"friday is the best day of the week.");
            preparedStatement12.setString(2,"of the week");
            preparedStatement12.setString(3,"ever");
            ResultSet res12 = preparedStatement12.executeQuery();
            res12 .next();
                String r12 = res12 .getString(1);
                System.out.println(r12);

        System.out.println("\nREGEX_SUBSTR - Function :");
        PreparedStatement preparedStatement13 = mysqlConnection.prepareStatement("SELECT REGEXP_SUBSTR(?,'[-\\_] V[0-9]+', 1, 1, 'i')");
            preparedStatement13.setString(1,"_V853012196559755633116459503");
            ResultSet res13 = preparedStatement13.executeQuery();
            res13 .next();
                String r13 = res13 .getString(1);
                System.out.println(r13);

        System.out.println("\nREGEX_INSTRING - Function :");
        PreparedStatement preparedStatement14 = mysqlConnection.prepareStatement("SELECT REGEXP_INSTR(?,'[0-9]', 1, 1, 0)");
            preparedStatement14.setString(1,"_V853012196559755633116459503");
            ResultSet res14 = preparedStatement14.executeQuery();
            res14.next();
                int r14 = res14.getInt(1);
                System.out.println("Regex String Count: "+ r14);

        System.out.println("\nSUBSTRING- Function :");
        PreparedStatement preparedStatement15 = mysqlConnection.prepareStatement("SELECT SUBSTRING('Sakila',-4, 2)");
            ResultSet res15 = preparedStatement15.executeQuery();
            res15.next();
                String r15 = res15.getString(1);
                System.out.println(r15);

        System.out.println("\nSTRING_COMPARE- Function :");
        PreparedStatement preparedStatement16 = mysqlConnection.prepareStatement("SELECT STRCMP('text', 'text2')");
            ResultSet res16 = preparedStatement16.executeQuery();
            res16 .next();
                int r16 = res16 .getInt(1);
                System.out.println(r16);

            System.out.println("\nROUND_OFF- Function :");
        PreparedStatement preparedStatement17 = mysqlConnection.prepareStatement("SELECT ROUND(CURRENT_DATE,'YEAR');");
            ResultSet res17 = preparedStatement17.executeQuery();
            res17.next();
                int r17 =res17.getInt(1);
                System.out.println(r17);

        System.out.println("\nCONVERT - Function :");
        PreparedStatement preparedStatement18 = mysqlConnection.prepareStatement("SELECT CONVERT('2017-08-29', DATETIME)");
            ResultSet res18 = preparedStatement18.executeQuery();
            res18.next();
                String r18 =res18.getString(1);
                System.out.println(r18);

        System.out.println("\nFIND_IN_SET - Function :");
        PreparedStatement preparedStatement19 = mysqlConnection.prepareStatement("SELECT FIND_IN_SET('a', 'b,a,v,a,d')");
            ResultSet res19 = preparedStatement19.executeQuery();
            res19.next();
                int r19 =res19.getInt(1);
                System.out.println("Position:" +r19);

    }
}
