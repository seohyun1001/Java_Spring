package com.bitc.java404.ParsingQuiz;

public class Main {
    public static void main(String[] args) {
        ParsingQuiz pq = new ParsingQuiz();
        try {
            //https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101
            String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.";
            String serviceKey = "?key=";
            String myKey = "f5eef3421c602c6cb7ea224104795888";
            String opt1 = "&targetDt=";
            String serviceUrl = url + "json" + serviceKey + myKey + opt1 + "20140403";
            pq.dailyBoxOfficeUrl(serviceUrl);

        } catch (Exception e) {

        }
    }
}
