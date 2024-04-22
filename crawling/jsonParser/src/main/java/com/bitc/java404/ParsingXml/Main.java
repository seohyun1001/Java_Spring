package com.bitc.java404.ParsingXml;

public class Main {
    public static void main(String[] args) {
        xmlParsing xp = new xmlParsing();
        try {
            xp.jsonToXml();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        xmlParsing xp2 = new xmlParsing();

        try {
            String serviceUrl = "https://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire?serviceKey=OZMZjB5InsoJu%2FpOv0C12iG18R98mNEYkVuIrLqMQF5pROiKGJvJfNi8tBKV%2BH2jKvr2VMzC9IgvzRTw7jA8cg%3D%3D&Q0=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C&Q1=%EA%B0%95%EB%82%A8%EA%B5%AC&QT=1&QN=%EC%82%BC%EC%84%B1%EC%95%BD%EA%B5%AD&ORD=NAME&pageNo=1&numOfRows=10";
//            String serviceKey = "?serviceKey=";
//            String myKey = "OZMZjB5InsoJu%2FpOv0C12iG18R98mNEYkVuIrLqMQF5pROiKGJvJfNi8tBKV%2BH2jKvr2VMzC9IgvzRTw7jA8cg%3D%3D&Q0=%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C&Q1=%EA%B0%95%EB%82%A8%EA%B5%AC&QT=1&QN=%EC%82%BC%EC%84%B1%EC%95%BD%EA%B5%AD";
//            String opt1 = "&ORD=";
//            String opt2 = "&pageNo=";
//            String opt3 = "&numOfRows=";
            xp2.xmlToObjectUrl(serviceUrl);

        } catch (Exception e) {

        }


    }
}