package org.example.execute;

import org.example.connection.PostgreSqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSqlExecute {

    public void ExecutePostgresQuery() throws SQLException {
        PostgreSqlConnection postgres = new PostgreSqlConnection();
        Connection postgresConnection = postgres.connectPostgres();

        System.out.println("Group Concat - Function :");
        PreparedStatement preparedStatement = postgresConnection.prepareStatement("select empcode, array_agg(skill) from EMPLOYEE group by empcode");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int r1 = rs.getInt(1);
            String r2 = rs.getString(2);
            System.out.println(r1 + "-" + r2);
        }
        System.out.println("\nROUND_OFF - Function :");
        PreparedStatement prepare1 = postgresConnection.prepareStatement("select round(?/100,-1.34 :: integer),round(?/100,1.34 :: integer)");
        prepare1.setInt(1, 12345);
        prepare1.setInt(2, 12345);
        ResultSet rs1 = prepare1.executeQuery();
        rs1.next();
        {
            double r1 = rs1.getInt(1);
            double r2 = rs1.getDouble(2);
            System.out.println("RoundedValue:" + r1 + " , " + "RoundedValue:" + r2);
        }
        System.out.println("\nTRUNCATE - Function :");
        PreparedStatement prepare2 = postgresConnection.prepareStatement("SELECT TRUNC(135.375, 1),TRUNC(135.375, 5),TRUNC(13, 1)");
        ResultSet rs2 = prepare2.executeQuery();
        rs2.next();
            double r1 = rs2.getDouble(1);
            double r2 = rs2.getDouble(2);
            int r3 = rs2.getInt(3);
            System.out.println("TruncatedValue:" + r1 + " , " + "TruncatedValue:" + r2 + " , " + "TruncatedValue:" + r3);

        System.out.println("\nDATE - Function :");
        PreparedStatement prepare3 = postgresConnection.prepareStatement("select  DATE '2022-09-15' - interval '10 DAY'");
        ResultSet rs3 = prepare3.executeQuery();
        rs3.next();
            System.out.println(rs3.getDate(1));

        System.out.println("\nTRUNCATE - Function :");
        PreparedStatement prepare4 = postgresConnection.prepareStatement("SELECT TRUNC(32.4567, 2)");
        ResultSet rs4 = prepare4.executeQuery();
        rs4.next();
            double r4 = rs4.getDouble(1);
            System.out.println("TruncatedValue:" + r4);

        System.out.println("\nLENGTH - Function :");
        PreparedStatement prepare5 = postgresConnection.prepareStatement("SELECT length('Mary Colem  an')");
        ResultSet rs5 = prepare5.executeQuery();
        rs5.next();
            int r5 = rs5.getInt(1);
            System.out.println("String Length:" + r5);

        System.out.println("\nSUBSTRING - Function :");
        PreparedStatement prepare6 = postgresConnection.prepareStatement("SELECT  SUBSTR('Mary Colem  an',4,4)");
        ResultSet rs6 = prepare6.executeQuery();
        rs6.next();
            String r6 = rs6.getString(1);
            System.out.println("String Length:" + r6);

        System.out.println("\nSTRING_POSITION - Function :");
        PreparedStatement prepare7 = postgresConnection.prepareStatement("select POSITION('W'in 'HelloWorld')");
        ResultSet rs7 = prepare7.executeQuery();
        rs7.next();
            String r7 = rs7.getString(1);
            System.out.println(" MatchPosition:" + r7);

        System.out.println("\nTIME - Function :");
        PreparedStatement prepare8 = postgresConnection.prepareStatement("SELECT EXTRACT (EPOCH FROM '13:20:10'::time)");
        ResultSet rs8 = prepare8.executeQuery();
        rs8.next();
            int r8 = rs8.getInt(1);
            System.out.println(" Time to Seconds:" + r8);

        System.out.println("\nTIMESTAMP - Function :");
        PreparedStatement prepare9 = postgresConnection.prepareStatement("select to_char(to_timestamp(1447430881)::TIMESTAMP,\n" +
                                                                             "'YYYY DDth Month HH12:MI:SS YYYY')");
        ResultSet rs9 = prepare9.executeQuery();
        rs9.next();
            String r9 = rs9.getString(1);
            System.out.println(r9);

        System.out.println("\nSTRING_POSITION - Function :");
        PreparedStatement prepare10 = postgresConnection.prepareStatement("SELECT  position('a' in replace('b,a,v,a,d',',',''))");
        ResultSet rs10 = prepare10.executeQuery();
        rs10.next();
            int r10 = rs10.getInt(1);
            System.out.println("Position : " + r10);

        System.out.println("\nCONCAT - Function :");
        PreparedStatement prepare11 = postgresConnection.prepareStatement("SELECT CONCAT_WS('-','Open','Source','Relational','DBMS')");
        ResultSet rs11 = prepare11.executeQuery();
        rs11.next();
            String r11 = rs11.getString(1);
            System.out.println("ConcatenatedString : " + r11);

        System.out.println("\nDATE - Function :");
        PreparedStatement prepare12 = postgresConnection.prepareStatement("select extract(day from DATE '2017-06-15')");
        ResultSet rs12 = prepare12.executeQuery();
        rs12.next();
            String r12 = rs12.getString(1);
            System.out.println("Number of Days : " + r12);

        System.out.println("\nREGEX_REPLACE - Function :");
        PreparedStatement prepare13 = postgresConnection.prepareStatement("select regexp_replace(?,?, ?, 1, 1 )");
        prepare13.setString(1,"friday is the best day of the week.");
        prepare13.setString(2,"of the week");
        prepare13.setString(3,"ever");
        ResultSet rs13 = prepare13.executeQuery();
        rs13.next();
            String r13 = rs13.getString(1);
            System.out.println(r13);

        System.out.println("\nREGEX_SUBSTR - Function :");
        PreparedStatement prepare14 = postgresConnection.prepareStatement("SELECT REGEXP_SUBSTR(?,'[-\\_] V[0-9]+', 1, 1, 'i')");
        prepare14.setString(1,"_V853012196559755633116459503");
        ResultSet rs14 = prepare14.executeQuery();
        rs14 .next();
            String r14 = rs14 .getString(1);
            System.out.println(r14);

        System.out.println("\nREGEX_INSTRING - Function :");
        PreparedStatement prepare15 = postgresConnection.prepareStatement("SELECT REGEXP_INSTR(?,'[0-9]', 1, 1, 0)");
        prepare15.setString(1,"_V853012196559755633116459503");
        ResultSet rs15 = prepare15.executeQuery();
        rs15.next();
            int r15 = rs15 .getInt(1);
            System.out.println(r15);

        System.out.println("\nSUBSTRING - Function :");
        PreparedStatement prepare16 = postgresConnection.prepareStatement("SELECT SUBSTRING(right('Sakila',-1),2,2)");
        ResultSet rs16 = prepare16.executeQuery();
        rs16.next();
            String r16 = rs16 .getString(1);
            System.out.println(r16);

        System.out.println("\nSTRING_COMPARE - Function :");
        PreparedStatement prepare17 = postgresConnection.prepareStatement("select  case \n" +
                "       WHEN 'text' = 'text2' THEN 0\n" +
                "       WHEN 'text' < 'text2' THEN -1\n" +
                "       ELSE 1\n" +
                "end");
        ResultSet rs17 = prepare17.executeQuery();
        rs17.next();
            int r17 = rs17.getInt(1);
            System.out.println(r17);

        System.out.println("\nROUND_OFF - Function :");
        PreparedStatement prepare18 = postgresConnection.prepareStatement("select to_char(current_date,'YYYYMMDD')::INTEGER");
        ResultSet rs18 = prepare18.executeQuery();
        rs18.next();
        String r18 = rs18.getString(1);
        System.out.println(r18);

        System.out.println("\nCONVERT - Function :");
        PreparedStatement prepare19 = postgresConnection.prepareStatement("select TO_DATE('2022 03','YYYY MM D')");
        ResultSet rs19 = prepare19.executeQuery();
        rs19.next();
        String r19 = rs19.getString(1);
        System.out.println(r19);

    }
}