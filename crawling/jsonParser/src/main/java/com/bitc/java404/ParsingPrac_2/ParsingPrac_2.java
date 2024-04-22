package com.bitc.java404.ParsingPrac_2;

import com.bitc.java404.ParsingPrac_2.DTO.*;
import com.google.gson.Gson;

import java.util.List;

public class ParsingPrac_2 {
    public void tagoParser() {
        String jsonData = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":[{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406061200,\"depplacename\":\"서울\",\"depplandtime\":20240406051200,\"traingradename\":\"KTX\",\"trainno\":1},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406063200,\"depplacename\":\"서울\",\"depplandtime\":20240406052700,\"traingradename\":\"KTX\",\"trainno\":3},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406070200,\"depplacename\":\"서울\",\"depplandtime\":20240406055700,\"traingradename\":\"KTX\",\"trainno\":5},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406073800,\"depplacename\":\"서울\",\"depplandtime\":20240406063200,\"traingradename\":\"KTX\",\"trainno\":7},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406074800,\"depplacename\":\"서울\",\"depplandtime\":20240406064200,\"traingradename\":\"KTX\",\"trainno\":233},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406080700,\"depplacename\":\"서울\",\"depplandtime\":20240406065600,\"traingradename\":\"KTX\",\"trainno\":9},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406083200,\"depplacename\":\"서울\",\"depplandtime\":20240406072700,\"traingradename\":\"KTX\",\"trainno\":11},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406084700,\"depplacename\":\"서울\",\"depplandtime\":20240406074900,\"traingradename\":\"KTX\",\"trainno\":13},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406090200,\"depplacename\":\"서울\",\"depplandtime\":20240406075700,\"traingradename\":\"KTX\",\"trainno\":15},{\"adultcharge\":17200,\"arrplacename\":\"대전\",\"arrplandtime\":20240406095500,\"depplacename\":\"서울\",\"depplandtime\":20240406081100,\"traingradename\":\"KTX\",\"trainno\":121}]},\"numOfRows\":10,\"pageNo\":1,\"totalCount\":66}}}";

        System.out.println("========= TAGO 열차 정보 출력하기 =========");

        // Gsom 라이브러리 사용을 위해
        Gson gson = new Gson();

        // Gson을 사용하여 TagoDTO 클래스 타입으로 Json 문자열 데이터를 파싱
        TagoDTO tago = gson.fromJson(jsonData, TagoDTO.class);
        // 아래의 부분은 필요없으면 사용하지 않아도 됨
        TagoResponseDTO response = tago.getResponse();
        TagoHeaderDTO header = response.getHeader();
        TagoBodyDTO body = response.getBody();
        TagoItemsDTO items = body.getItems();
        List<TagoItemDTO> itemList = items.getItem();

        // TagoDTO 객체에서 한번에 필요한 데이터만 출력
        // List<TagoItemDTO> itemDTOList = tago.getResponse().getBody().getItems().getItem();

        for (TagoItemDTO item : itemList) {
            System.out.println("열차번호 : " + item.getTrainno());
            System.out.println("열차종류 : " + item.getTraingradename());
            System.out.println("출발지 : " + item.getDepplacename());
            System.out.println("출발시간 : " + item.getDepplandtime());
            System.out.println("도착지 : " + item.getArrplacename());
            System.out.println("도착시간 : " + item.getArrplandtime());
            System.out.println("열차운임 : " + item.getAdultcharge());
            System.out.println("============================================");

        }



    }
}
