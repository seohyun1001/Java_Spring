package com.bitc.java404.quiz4;

public class Quiz4_Main {

    public static void main(String[] args) {

        DaumNews daumNews = new DaumNews();

        String url =  "https://news.daum.net/?nil_profile=mini&nil_src=news";
        String csvFile = "c:/java404/quiz4_ksh.csv";

        daumNews.newsParsing(url,csvFile);

    }

}
