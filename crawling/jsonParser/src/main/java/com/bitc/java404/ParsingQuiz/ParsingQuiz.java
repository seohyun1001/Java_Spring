package com.bitc.java404.ParsingQuiz;

import com.bitc.java404.ParsingQuiz.DTO.BoxOfficeDTO;
import com.bitc.java404.ParsingQuiz.DTO.DailyBoxOfficeItemDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ParsingQuiz{
    // 문제 1) 영화 진흥원 API 중 일간 박스 오피스 API를 사용하여 지정한 날짜의 박스 오피스 내용을 가져와 화면에 출력하는 프로그램을 작성하세요
    // 메소드명 : dailyBoxOfficeUrl(String url);
    // main 메소드에서 dailyBoxOfficeUrl()로 url 전달 시 날짜를 입력할 수 있도록 작성
    // 출력 정보 : 랭크, 영화 코드, 영화명, 개봉일, 일일 관람객 수, 누적 관람객 수

    public void dailyBoxOfficeUrl(String serviceUrl) throws Exception {
        List<DailyBoxOfficeItemDTO> itemList = null;

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

            Gson gson= new Gson();
            BoxOfficeDTO boxOffice = gson.fromJson(sb.toString(), BoxOfficeDTO.class);
            itemList = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {reader.close();}
            if (urlConn != null) {urlConn.disconnect();}
        }

        // 출력 정보 : 랭크, 영화 코드, 영화명, 개봉일, 일일 관람객 수, 누적 관람객 수
        for (DailyBoxOfficeItemDTO item : itemList) {
            System.out.println("랭크 : " + item.getRank() + "위");
            System.out.println("영화 코드 : " + item.getMovieCd());
            System.out.println("영화명 : " + item.getMovieNm());
            System.out.println("개봉일 : " + item.getOpenDt());
            System.out.println("일일 관람객 수 : " + item.getAudiCnt());
            System.out.println("누적 관람객 수 : " + item.getAudiAcc());
            System.out.println("============================================");
        }


    }



}
