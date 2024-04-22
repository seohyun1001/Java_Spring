package com.bitc.java404.databaseParsing;

import java.sql.*;

public class ParserToDB {

    public void insertDB() {

        Connection conn = null;

        // setting connecting addr to JDBC
        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "java404";
        String dbPass = "java404";

        // class for sending sql query from jdbc to dbms and receiving the result value
        // statement : use when apply simple sql query, must close the object after apply(no recycle) sql maked by String type of character
        // PreparedStatement : use when apply complex sql query. can recycle after applying and send query again. can input the proper data late to use '?' in the made String type of characters
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            // create sql query to apply
            String sql = "insert into member (user_id, user_pw, user_name, user_email, user_phone, user_addr) values (?, ?, ?, ?, ?, ?);";

            // receive PrepareStatement object through the connected object to DB
            pstmt = conn.prepareStatement(sql);
            // add data in the '?' through setXXX() method
            // setXXX() method supplies all the basic data type
            // the first parameter in the setXXX() method is the number of '?'
            // the second param in the setXXX() method is the data to input
            pstmt.setString(1, "test3");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "tester3");
            pstmt.setString(4, "test3.naver.com");
            pstmt.setString(5, "01010002000");
            pstmt.setString(6, "seoul");

            // executeQuery() : use when carry out sql - select / output the return value to type 'ResultSet'
            // executeUpdate() : use when carry out sql - insert, update, delete / output the return value - count of result
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("added " + result + " data(s)");
            } else {
                System.out.println("Fail adding data");
            }

        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println("SQLException : " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());

        } finally {
            try {
                if (conn != null) {conn.close();}
            } catch (Exception e) {

            }
        }
    }

    public void selectDB() {
        Connection conn = null;

        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "java404";
        String dbPass = "java404";

        // create Statement object for using sql query
        Statement stmt = null;
        // class receive the information of database
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            // create select query
            String sql = "select * from member";

            // create the object 'Statement' through the object 'Connection'

            stmt = conn.createStatement();
            // receive the result value for using execute() after applying select
            // save the result value in object 'rs' type of 'ResultSet'
            rs = stmt.executeQuery(sql);

            // next() : bring the data when the data is existing
            // or output 'false; when the data isn't existing
            while (rs.next()) {
                // bring the data to use getXXX()
                // getXXX() receive some parameters through method overloading
                // 1) bring the column data representing number of order to receive number of index
                // 2) bring the column data to input name of column directly
                String userID = rs.getString("user_id");
                String userPw = rs.getString("user_pw");
                String userName = rs.getString("user_name");
                String userEmail = rs.getString("user_email");
                String userPhone = rs.getString("user_phone");
                String userAddr = rs.getString("user_addr");

                System.out.println("ID : " + userID);
                System.out.println("PW : " + userPw);
                System.out.println("Name : " + userName);
                System.out.println("Email : " + userEmail);
                System.out.println("Phone : " + userPhone);
                System.out.println("Address : " + userAddr);
                System.out.println("=======================================");
            }

        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println("SQLException : " + e.getMessage());
        } catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
        } finally {
            try{
                // the order to close is the opposite order opened
                if (rs != null) {rs.close();}
                if (stmt != null) {stmt.close();}
                if (conn != null) {conn.close();}

            } catch (Exception e){

            }
        }

    }

    public void deleteDB(String userID) {
        Connection conn = null;

        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUser = "java404";
        String dbPass = "java404";

        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "delete from member where user_id = '" + userID + "' ";

            stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            if (result > 0) {
                System.out.println("delete" + result + " data(s)");
            } else {
                System.out.println("No deleted data");
            }


        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println("SQLException : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());

        } finally {
            try {
                if (stmt != null) {stmt.close();}
                if (conn != null) {conn.close();}

            } catch (Exception e){

            }
        }
    }



    public void updateDB() {
        Connection conn = null;
        String dbUrl = "jdbc:mysql://localhost:3306/testdb";
        String dbUser = "java404";
        String dbPass = "java404";

        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "update member set ";
            sql += "user_name = ?, user_email = ?, user_phone = ? ";
            sql += "where user_id = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "tester_01");
            pstmt.setString(2, "test1@gmail.com");
            pstmt.setString(3, "01010012002");
            pstmt.setString(4, "test1");

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("update " + result + " data(s)");
            } else {
                System.out.println("No updated data");
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println("SQLException : " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());

        } finally {
            try {
                if (pstmt != null) {pstmt.close();}
                if (conn != null) {conn.close();}

            } catch (Exception e){

            }
        }
    }
}
