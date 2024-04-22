package com.bitc.java404.quiz2;

import com.bitc.java404.quiz2.DTO.BoxOfficeDTO;
import com.bitc.java404.quiz2.DTO.WeeklyBoxOfficeDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ParsingBoxOffice {

    public void weeklyBoxOffice(String serviceUrl) throws Exception{

        List<WeeklyBoxOfficeDTO> itemList = null;

        URL url = null;
        HttpURLConnection conn = null;
        BufferedReader reader = null;

        try {
            url = new URL(serviceUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            Gson gson = new Gson();
            BoxOfficeDTO boxOffice = gson.fromJson(sb.toString(), BoxOfficeDTO.class);
            itemList = boxOffice.getBoxOfficeResult().getWeeklyBoxOfficeList();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (reader != null) {reader.close();}
            if (conn != null) {conn.disconnect();}

        }


//        System.out.println("기간 : ");
//        랭킹, 영화명, 관람객 수 출력은 필수
        for (WeeklyBoxOfficeDTO item : itemList) {
            System.out.println("랭킹 : " + item.getRank() + "위");
            System.out.println("영화명 : " + item.getMovieNm());
            System.out.println("일일 관람객 수 : " + item.getAudiCnt() + "명");
            System.out.println("누적 관람객 수 : " + item.getAudiAcc() + "명");
            System.out.println("-----------------------------");

        }

    }


}
