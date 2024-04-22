package com.bitc.java404.quiz5;

import com.bitc.java404.quiz5.DTO.DTO;
import com.bitc.java404.quiz5.DTO.ItemDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Quiz5 {

    public List<ItemDTO> tagoParserUrl(String serviceUrl) throws Exception {

        List<ItemDTO> itemList = null;

        URL url = null;
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;


            while ((line = reader.readLine()) != null) {

                sb.append(line);
            }

            Gson gson = new Gson();
            DTO tago = gson.fromJson(sb.toString(), DTO.class);

            itemList = tago.getResponse().getBody().getItems().getItem();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }

        return itemList;
    }



    public void insertDB(List<ItemDTO> itemList) {

        String dbUrl = "jdbc:mysql://localhost:3306/quiz5_ksh_db?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "root";
        String dbPass = "java404";

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);

            String sql = "insert into tago values(?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            for (ItemDTO item : itemList){
                pstmt.setString(1, item.getAdultcharge());
                pstmt.setString(2, item.getArrplacename());
                pstmt.setString(3, item.getArrplandtime());
                pstmt.setString(4, item.getDepplacename());
                pstmt.setString(5, item.getDepplandtime());
                pstmt.setString(6, item.getTraingradename());
                pstmt.setString(7, item.getTrainno());

                pstmt.executeUpdate();
            }

            int rowCount = pstmt.getUpdateCount();

            if (rowCount > 0) {System.out.println(rowCount + "건 추가 완료");}
            else {System.out.println("데이터 추가 실패");}

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



}
