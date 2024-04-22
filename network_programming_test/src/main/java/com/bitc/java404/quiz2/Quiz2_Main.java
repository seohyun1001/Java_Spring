package com.bitc.java404.quiz2;

public class Quiz2_Main {
    public static void main(String[] args) {
        ParsingBoxOffice pbo = new ParsingBoxOffice();
//    https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20240407

        try {
            String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
            String serviceKey = "?key=";
            String myKey = "f5eef3421c602c6cb7ea224104795888";
            String opt = "&targetDt=";
            int targetDate = 20240407;
            String serviceUrl = url + serviceKey + myKey + opt + targetDate;

            System.out.println("기간 : " + (targetDate - 2) + " ~ " + targetDate);
            pbo.weeklyBoxOffice(serviceUrl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}