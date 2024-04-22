package com.bitc.java404.quiz5;

import com.bitc.java404.quiz5.DTO.ItemDTO;

import java.util.List;

public class Quiz5_Main {

    public static void main(String[] args) {
        Quiz5 quiz5 =  new Quiz5();

        List<ItemDTO> itemList = null;

        try {
            String url = "https://apis.data.go.kr/1613000/TrainInfoService/getStrtpntAlocFndTrainInfo";
            String serviceKey = "?serviceKey=";
            String myKey = "OZMZjB5InsoJu%2FpOv0C12iG18R98mNEYkVuIrLqMQF5pROiKGJvJfNi8tBKV%2BH2jKvr2VMzC9IgvzRTw7jA8cg%3D%3D";
            String opt1 = "&pageNo=";
            String opt2 = "&numOfRows=";
            String opt3 = "&_type=";
            String opt4 = "&depPlaceId=";
            String opt5 = "&arrPlaceId=";
            String opt6 = "&depPlandTime=";
            String opt7 = "&trainGradeCode=";

            String serviceUrl = url + serviceKey + myKey
                    + opt1 + "1"
                    + opt2 + "100"
                    + opt3 + "json"
                    + opt4 + "NAT014445"
                    + opt5 + "NAT010000"
                    + opt6 + "20230420"
                    + opt7 + "00";

            itemList = quiz5.tagoParserUrl(serviceUrl);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        if (itemList != null) {
            quiz5.insertDB(itemList);
        }

    }

}
