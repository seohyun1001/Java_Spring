package com.bitc.java404.JsonTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("JSON 파싱하기");

        // json이란 : javascript object notation의 약자로,
        // 자바스크립트 객제 표기법이라는 의미
        // 데이터를 쉽게 전달하고 저장하기 위한 텍스트 기반의 데이터 교환 표준이다.
        // 자바스크립트의 object 타입을 흉내내서 문자열로 만들어 놓은 것
        // key:value 형태로 데이터를 저장하고, 각각의 데이터는 ','로 구분
        // value로 값 자체를 입력할 수 있고, value로 배열[]이나, object{} 타입을 입력할 수 있음

        // 자바에서 직접 json을 사용할 수 없기 때문에
        // json 데이터를 파싱하기 위한 라이브러리가 필요함
        // -> gson : 구글에서 개발한 자바용 json 파싱 라이브러리

        GsonTest gt = new GsonTest();
        gt.createJson();
        gt.objectToJson();
        gt.jsonToObject();
        gt.mapToJson();
        gt.jsontoMap();
        System.out.println("==============================================");
        gt.jsonStringParser();
    }
}