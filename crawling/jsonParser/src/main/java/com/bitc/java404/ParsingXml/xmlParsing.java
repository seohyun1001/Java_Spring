package com.bitc.java404.ParsingXml;

import com.bitc.java404.ParsingXml.DTO.PharmacyDTO;
import com.bitc.java404.ParsingXml.DTO.PharmacyItemDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class xmlParsing {
    public  void jsonToXml() throws Exception{
        // JAXB 라이브러리를 사용하여 xml 파싱
        // jaxb :  자바에서 xml 데이터 파싱을 도와주는 라이브러리
        // -> java9부터 자바 기본 라이브러리에서 제외됨 -> 종속성 추가가 필요함
        // json 문자열 파싱과 동일하게 미리 해당 데이터와 맞는 dto(or vo)클래스를 선언하여 xml 데이터를 파싱

        // 필요한 종속성
        // jakarta.xml.bind-api
        // jakarta.activation-api
        // jaxb-impl

        // marshal : 자바 클래스를 xml 데이터로 변환
        // unmarshal :  xml 데이터를 자바 클래스 타입의 객체로 변환

        JAXBContext jc = JAXBContext.newInstance(PharmacyDTO.class);
        Unmarshaller um = jc.createUnmarshaller();

        PharmacyDTO pharmacy = (PharmacyDTO) um.unmarshal(new File("C:/java404/pharmacy.xml"));

        List<PharmacyItemDTO> itemList = pharmacy.getBody().getItems().getItem();

        for (PharmacyItemDTO item : itemList) {
            System.out.println("약국 이름 : " + item.getDutyName());
            System.out.println("전화번호 : " + item.getDutyTel1());
            System.out.println("주소 : " + item.getDutyAddr());
            System.out.println("시작 시간 : " +item.getDutyTime1s());
            System.out.println("종료 시간 : " + item.getDutyTime1c());
            System.out.println("========================================");
        }
    }



    public void xmlToObjectUrl(String serviceUrl) throws Exception{
        List<PharmacyItemDTO> itemList = null;

        URL url = null;
        HttpURLConnection urlConn = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(PharmacyDTO.class);
            Unmarshaller um = jc.createUnmarshaller();

            PharmacyDTO pharmacy = (PharmacyDTO) um.unmarshal(url);
            itemList = pharmacy.getBody().getItems().getItem();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (urlConn != null) { urlConn.disconnect();}
        }

        System.out.println("\n =========== 전국 약국 정보(url) =========== \n");
        for (PharmacyItemDTO item : itemList) {
            System.out.println("약국 이름 : " + item.getDutyName());
            System.out.println("전화번호 : " + item.getDutyTel1());
            System.out.println("주소 : " + item.getDutyAddr());
            System.out.println("시작 시간 : " +item.getDutyTime1s());
            System.out.println("종료 시간 : " + item.getDutyTime1c());
            System.out.println("=======================================");
        }

    }
}
