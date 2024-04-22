package com.bitc.java404.ParsingPrac_3;

import com.bitc.java404.ParsingPrac_2.DTO.TagoDTO;
import com.bitc.java404.ParsingPrac_2.DTO.TagoItemDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ParsingPrac_3 {
    public void tagoParserUrl(String serviceUrl) throws Exception{
        // 열차 정보를 저장할 list
        List<TagoItemDTO> itemList = null;

        // 열차 정보를 제공하는 서비스의 url 정보를 입력하기 위한 자바에서 제공하는 URL 객체
        URL url = null;
        // 지정한 URL을 기반으로 http 프로토콜로 접속하여 데이터를 가져오는 클래스
        HttpURLConnection urlConn = null;
        // HttpURLConnection을 통해서 서비스에 접근하여 가져온 데이터를 빠르게
        BufferedReader reader = null;

        try {
            // 매개변수로 받아온 서비스 주소를 URL 클래스 타입의 객체로 생성
            url = new URL(serviceUrl);
            // openConnection()을 사용하여 지정한 url로 접속
            // 접속 정보를 HttpURLConnection 타입의 객체에 넘김
            urlConn = (HttpURLConnection) url.openConnection();
            // 접속 방식을 GET 타입으로 설정
            urlConn.setRequestMethod("GET");

            // getInputStream()을 사용하여 접속한 서비스에서 데이터를 가져옴
            // BufferedReader를 사용하여 서비스를 제공하는 곳에서 데이터를 가져와서 버퍼에 저장 후 한번에 가져옴
            reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            // StringBuilser 혹은 StringBuffer 타입을 사용하는 이유
            // String 타입은 2개 이상의 문자열을 합하여 하나의 문자열을 생성 시 기존 문자열에 새로운 문자열을 합하여 하나의 길다란 문자열을 만드는 것이 아니라, 기존의 문자열이 저장되어 있는 메모리 공간을 그대로 두고, 새로운 메모리 공간을 생성하여 하나의 길다란 문자열을 입력하여 사용자에게 제공하는 형태임
            // String 타입을 통한 빈번한 문자열의 연결은 비효율적인 메모리 사용을 야기하기 때문에 StringBuilder, StringBuffer 타입을 사용하는 것이 좋음
            // StringBuilder, StringBuffer 타입은 객체 생성 시 만들어진 하나의 메모리 공간에서 데이터를 추가, 수정, 삭제하는 것이 가능하기 때문에 메모리를 효율적으로 사용할 수 있음
            // StringBuffer는 스레드에 안전함 -> 속도가 빠르다(멀티 스레드 환경에서 사용)
            // StringBuilder는 스레드에 안전하지 않음 -> 속도가 느리다(싱글 스레드 환경에서 사용)

            // StringBuilder 타입의 객체를 생성
            StringBuilder sb = new StringBuilder();
            String line = null;

            // HttpURLConnection을 통해서 가져온 네트워크 데이터를 BufferedReader를 통해서 데이터를 한 줄씩 가져옴
            while ((line = reader.readLine()) != null){
                // 가져온 데이터를 StringBuilder 타입의 문자열 변수 sb에 추가함 -> 데이터를 계속 넣어도 메모리 사용은 그대로
                sb.append(line);
            }

            Gson gson = new Gson();
            // sb.toString()을 사용하여 가져온 json 문자열 데이터를 TagoDTO 클래스 타입으로 파싱
            TagoDTO tago = gson.fromJson(sb.toString(), TagoDTO.class);
            // TagoDTO 클래스 타입의 객체에서 필요한 데이터를 모두 출력
            itemList = tago.getResponse().getBody().getItems().getItem();

        } catch (Exception e){

            e.printStackTrace();

        } finally {
            // 사용 후 반드시 외부 리소스 해제
            if (reader != null) {reader.close();}
            if (urlConn != null) {urlConn.disconnect();}
        }

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
