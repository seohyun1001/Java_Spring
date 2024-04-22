package com.bitc.java404.plusDTO;

import java.sql.*;

public class memberDAO {

    public void selectDB() {
        Connection conn = null;

        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "java404";
        String dbPass = "java404";

        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "select * from member";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
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
                if (rs != null) {rs.close();}
                if (stmt != null) {stmt.close();}
                if (conn != null) {conn.close();}

            } catch (Exception e){

            }
        }

    }




    public void insertDB(memberDTO member) {

        Connection conn = null;

        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "java404";
        String dbPass = "java404";

        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "insert into member (user_id, user_pw, user_name, user_email, user_phone, user_addr) values (?, ?, ?, ?, ?, ?);";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, member.getUser_id());
            pstmt.setString(2, member.getUser_pw());
            pstmt.setString(3, member.getUser_name());
            pstmt.setString(4, member.getUser_email());
            pstmt.setString(5, member.getUser_phone());
            pstmt.setString(6, member.getUser_addr());

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



    public void updateDB(memberDTO member) {
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
            pstmt.setString(1, member.getUser_name());
            pstmt.setString(2, member.getUser_email());
            pstmt.setString(3, member.getUser_phone());
            pstmt.setString(4, member.getUser_id());

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
