package com.bitc.java404;

import com.bitc.java404.BoxOfficeDTO.DailyBoxOfficeList;

import java.util.List;

public class BoxOfficeMain {
    public static void main(String[] args) {

        System.out.println("\n save the json data brought at url to DB \n");

        // service addr for serving json data
        String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
        // key setting for using service
        String serviceKey = "?key=";
        String myKey = "f5eef3421c602c6cb7ea224104795888";
        // setting option for suppling service
        String opt1 = "&targetDt=";

        String serviceUrl = url + serviceKey + myKey + opt1 + "20240404";

        // create object type = BoxOfficeParser
        BoxOfficeParser parser = new BoxOfficeParser();
        // bring json data to connect api service to apply jsonToObjectUrl and parse
        List<DailyBoxOfficeList> itemList = parser.jsonToObjectUrl(serviceUrl);

        for (DailyBoxOfficeList item : itemList) {
            // add data to DB to connect DBMS to apply insertDailyBoxOffice()
            parser.insertDailyBoxOffice(item);
        }
    }
}
