package com.bitc.java404.databaseParsing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void dbTest() {
        System.out.println("test for using database");

        // class for connecting DB server
        Connection conn = null;

        try {
            // DB connecting addr
            String url = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
            String userID = "java404";
            String userPW = "java404";

            // loading jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connect using user Id/PW to selected DB
            conn = DriverManager.getConnection(url,userID,userPW);
            System.out.println("Success connection to DB");

        } catch (SQLException e) {
            System.out.println("Fail connection to DB");
            System.out.println("SQLException : " + e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                // user must close the object 'Connection' directly
                // because Connection is the outside resource
                if (conn != null) {conn.close();}
            } catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        dbTest();

        ParserToDB parser = new ParserToDB();
//        parser.insertDB();
        parser.selectDB();
        System.out.println("=========== delete data 'test3' ===========");
        parser.deleteDB("test3");
        parser.selectDB();
        System.out.println("=========== update data 'test1' ===========");
        parser.updateDB();
        parser.selectDB();


    }
}