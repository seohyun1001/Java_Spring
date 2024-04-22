package com.bitc.java404.ParsingPrac_3;

public class Main {
    public static void main(String[] args) {
        ParsingPrac_3 pp3 = new ParsingPrac_3();
        try {
// https://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo
// ?serviceKey=OZMZjB5InsoJu%2FpOv0C12iG18R98mNEYkVuIrLqMQF5pROiKGJvJfNi8tBKV%2BH2jKvr2VMzC9IgvzRTw7jA8cg%3D%3D
// &pageNo=1
// &numOfRows=10
// &_type=json
// &depPlaceId=NAT010000&arrPlaceId=NAT011668
// &depPlandTime=20240406
// &trainGradeCode=00
            String url = "https://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo";
            String serviceKey = "?serviceKey=";
            String basic = "&depPlaceId=NAT010000&arrPlaceId=NAT011668";
            String opt1 = "&depPlandTime=";
            String opt2 = "&trainGradeCode=00";
            String opt3 = "&pageNo=";
            String opt4 = "&numOfRows=";
            String opt5 = "&_type=";
            String myKey = "OZMZjB5InsoJu%2FpOv0C12iG18R98mNEYkVuIrLqMQF5pROiKGJvJfNi8tBKV%2BH2jKvr2VMzC9IgvzRTw7jA8cg%3D%3D";
            String serviceUrl = url + serviceKey + myKey + basic + opt1 + "20240405" + opt2 + opt3 + "1" + opt4 + "20" + opt5 + "json";
            pp3.tagoParserUrl(serviceUrl);

        } catch (Exception e) {

        }

    }
}
