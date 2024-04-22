package com.bitc.java404.ParsingPrac_1;

import com.bitc.java404.ParsingPrac_1.DTO.BoxOfficeDTO;
import com.bitc.java404.ParsingPrac_1.DTO.BoxOfficeResultDTO;
import com.bitc.java404.ParsingPrac_1.DTO.DailyBoxOfficeItemDTO;
import com.google.gson.Gson;

import java.util.List;

public class ParsingPrac {
    public void dailyBoxOfficeParser() {
        String jsonData = "{\"boxOfficeResult\":{\"boxofficeType\":\"일별 박스오피스\",\"showRange\":\"20240401~20240401\",\"dailyBoxOfficeList\":[{\"rnum\":\"1\",\"rank\":\"1\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20234675\",\"movieNm\":\"파묘\",\"openDt\":\"2024-02-22\",\"salesAmt\":\"435784461\",\"salesShare\":\"35.5\",\"salesInten\":\"-1014977806\",\"salesChange\":\"-70\",\"salesAcc\":\"106229301669\",\"audiCnt\":\"46030\",\"audiInten\":\"-100505\",\"audiChange\":\"-68.6\",\"audiAcc\":\"11003337\",\"scrnCnt\":\"1242\",\"showCnt\":\"4285\"},{\"rnum\":\"2\",\"rank\":\"2\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20231041\",\"movieNm\":\"댓글부대\",\"openDt\":\"2024-03-27\",\"salesAmt\":\"379006927\",\"salesShare\":\"30.9\",\"salesInten\":\"-852048174\",\"salesChange\":\"-69.2\",\"salesAcc\":\"5421269040\",\"audiCnt\":\"39333\",\"audiInten\":\"-83686\",\"audiChange\":\"-68\",\"audiAcc\":\"580380\",\"scrnCnt\":\"1058\",\"showCnt\":\"4091\"},{\"rnum\":\"3\",\"rank\":\"3\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20248496\",\"movieNm\":\"고질라 X 콩: 뉴 엠파이어\",\"openDt\":\"2024-03-27\",\"salesAmt\":\"156068247\",\"salesShare\":\"12.7\",\"salesInten\":\"-745192723\",\"salesChange\":\"-82.7\",\"salesAcc\":\"3376865761\",\"audiCnt\":\"15627\",\"audiInten\":\"-72419\",\"audiChange\":\"-82.3\",\"audiAcc\":\"336608\",\"scrnCnt\":\"813\",\"showCnt\":\"2636\"},{\"rnum\":\"4\",\"rank\":\"4\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20236295\",\"movieNm\":\"듄: 파트2\",\"openDt\":\"2024-02-28\",\"salesAmt\":\"94768610\",\"salesShare\":\"7.7\",\"salesInten\":\"-174939236\",\"salesChange\":\"-64.9\",\"salesAcc\":\"22035923072\",\"audiCnt\":\"7351\",\"audiInten\":\"-13759\",\"audiChange\":\"-65.2\",\"audiAcc\":\"1893376\",\"scrnCnt\":\"456\",\"showCnt\":\"711\"},{\"rnum\":\"5\",\"rank\":\"5\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20236714\",\"movieNm\":\"극장판 스파이 패밀리 코드 : 화이트\",\"openDt\":\"2024-03-20\",\"salesAmt\":\"28625638\",\"salesShare\":\"2.3\",\"salesInten\":\"-112902118\",\"salesChange\":\"-79.8\",\"salesAcc\":\"2372349124\",\"audiCnt\":\"2983\",\"audiInten\":\"-11429\",\"audiChange\":\"-79.3\",\"audiAcc\":\"237991\",\"scrnCnt\":\"393\",\"showCnt\":\"535\"},{\"rnum\":\"6\",\"rank\":\"6\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20219375\",\"movieNm\":\"1980\",\"openDt\":\"2024-03-27\",\"salesAmt\":\"20617634\",\"salesShare\":\"1.7\",\"salesInten\":\"-39964244\",\"salesChange\":\"-66\",\"salesAcc\":\"312519379\",\"audiCnt\":\"2302\",\"audiInten\":\"-4144\",\"audiChange\":\"-64.3\",\"audiAcc\":\"34539\",\"scrnCnt\":\"396\",\"showCnt\":\"574\"},{\"rnum\":\"7\",\"rank\":\"7\",\"rankInten\":\"2\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20235838\",\"movieNm\":\"악은 존재하지 않는다\",\"openDt\":\"2024-03-27\",\"salesAmt\":\"13852898\",\"salesShare\":\"1.1\",\"salesInten\":\"-23044817\",\"salesChange\":\"-62.5\",\"salesAcc\":\"210039154\",\"audiCnt\":\"1477\",\"audiInten\":\"-1895\",\"audiChange\":\"-56.2\",\"audiAcc\":\"20785\",\"scrnCnt\":\"134\",\"showCnt\":\"192\"},{\"rnum\":\"8\",\"rank\":\"8\",\"rankInten\":\"7\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20173226\",\"movieNm\":\"패왕별희 디 오리지널\",\"openDt\":\"2017-03-30\",\"salesAmt\":\"7004668\",\"salesShare\":\"0.6\",\"salesInten\":\"-3475701\",\"salesChange\":\"-33.2\",\"salesAcc\":\"1287422150\",\"audiCnt\":\"864\",\"audiInten\":\"-422\",\"audiChange\":\"-32.8\",\"audiAcc\":\"139937\",\"scrnCnt\":\"92\",\"showCnt\":\"122\"},{\"rnum\":\"9\",\"rank\":\"9\",\"rankInten\":\"3\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20236732\",\"movieNm\":\"가여운 것들\",\"openDt\":\"2024-03-06\",\"salesAmt\":\"7090214\",\"salesShare\":\"0.6\",\"salesInten\":\"-9612775\",\"salesChange\":\"-57.6\",\"salesAcc\":\"1472869470\",\"audiCnt\":\"733\",\"audiInten\":\"-890\",\"audiChange\":\"-54.8\",\"audiAcc\":\"147399\",\"scrnCnt\":\"76\",\"showCnt\":\"94\"},{\"rnum\":\"10\",\"rank\":\"10\",\"rankInten\":\"11\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20236568\",\"movieNm\":\"목스박\",\"openDt\":\"2024-03-20\",\"salesAmt\":\"5776700\",\"salesShare\":\"0.5\",\"salesInten\":\"1281222\",\"salesChange\":\"28.5\",\"salesAcc\":\"144823705\",\"audiCnt\":\"720\",\"audiInten\":\"170\",\"audiChange\":\"30.9\",\"audiAcc\":\"16460\",\"scrnCnt\":\"23\",\"showCnt\":\"24\"}]}}";

        Gson gson = new Gson();
        // 미리 생성해 좋은 DTP 클래스(혹은 VO 클래스) 타입에 맞춰서 gson 라이브러리가 데이터를 파싱함
        // 최상위 클래스가 BoxOfficeDTO 클래스이므로 json 문자열의 데이터가 BoxOfficeDTO 클래스 타입의 객체에 모두 저장됨
        BoxOfficeDTO boxOffice = gson.fromJson(jsonData, BoxOfficeDTO.class);
        BoxOfficeResultDTO boxOfficeResult = boxOffice.getBoxOfficeResult();

        // 일간 영화 순위 정보가 있는 DailyBoxOfficeItemDTO 클래스 타입의 객체를 List에 담아 모두 가져옴
        List<DailyBoxOfficeItemDTO> itemList = boxOfficeResult.getDailyBoxOfficeList();
        for (DailyBoxOfficeItemDTO item : itemList) {
            System.out.println("순위 : " + item.getRank() + "위, 제목 : " + item.getMovieNm());
        }

    }
}
