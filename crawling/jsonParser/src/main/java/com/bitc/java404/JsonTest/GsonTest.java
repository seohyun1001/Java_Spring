package com.bitc.java404.JsonTest;

import com.bitc.java404.JsonTest.DTO.Student;

import java.util.HashMap;
import java.util.Map;

public class GsonTest {

    // Gson 객체 생성하기
    public void createGson() {
        Gson gson1 = new Gson(); // 일반 Gson 객체 생성
        Gson gson2 = new GsonBuilder().create();// 빌더 타입으로 객체 생성하기
    }



    // Json 생성하기
    public void createJson() {
        Gson gson = new Gson();

        // Json 객체 생성
        JsonObject jobj = new JsonObject();
        // addProperty() : Json 객체에 key와 value로 이루어진 데이터를 추가
        jobj.addProperty("name", "박병찬");
        jobj.addProperty("gender", "남성");
        jobj.addProperty("job", "농구선수");

        // toJson() : JsonObject 타입으로 생성된 데이터를 Json 문자열로 변환
        String jsonStr = gson.toJson(jobj);

        System.out.println(jsonStr);
    }

    // Java Object를 Json으로 변환
    public void objectToJson() {
        // Student 클래스 타입의 객체 생성 및 데이터 추가
        Student std = new Student(1, "박병찬");
        // Student 클래스 타입의 객체에 저장된 내용 확인
        System.out.println("java 객체 std의 값 : " + std.toString());

        // Gson 객체 생성
        Gson gson = new Gson();
        // Student 클래스 타입의 객체를 gson을 사용하여 json 문자열로 변환
        String jsonString = gson.toJson(std);

        System.out.println(jsonString);

    }

    // Json을 Java Object로 변환
    public void jsonToObject() {
        // json 문자열
        String str = "{\"no\":\"2\", \"name\":\"최종수\"}";

        // Gson 객체 생성
        Gson gson = new Gson();
        // Student 클래스 타입의 변수 생성
        // gson을 사용하여 json 문자열을 지정한 Student 클래스 타입으로 파싱
        Student std = gson.fromJson(str, Student.class);

        System.out.println(std.toString());
    }

    // Map 타입을 Json으로 변환
    public void mapToJson() {
        // HaspMap 타입의 변수 생성 후 데이터 추가
        Map<String,String> mapData = new HashMap<>();
        mapData.put("no", "3");
        mapData.put("name", "전영중");

        // Gson 객체 생성
        Gson gson = new Gson();
        // gson을 사용하여 map 타입의 데이터를 json 문자열로 변환
        String jsonStr = gson.toJson(mapData);

        System.out.println(jsonStr);
    }

    // Json을 Map 타입으로 변환
    public void jsontoMap() {
        // json 문자열 데이터 생성
        String strData = "{'no':'4','name':'성준수'}";
        Gson gson = new Gson();

        // 변환될 데이터를 저장할 Map 타입의 변수 생성
        // key는 문자열로 사용하는 것이 확실하기 때문에 String으로 설정
        // value는 어떤 데이터가 입력될지 모르기 때문에 object 타입으로 설정
        Map<String, Object> mapData = gson.fromJson(strData, Map.class);

        // Map 타입으로 변환된 데이터를 모두 출력
        for (Map.Entry<String, Object> entry : mapData.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }


    }

    public void jsonStringParser() {
        // 원본 json 문자열 데이터
        String json = "{'no':1,'students':['박병찬','최종수']," +
                "'subject':{'name':'java','professor':'lgh'}}";

        // Gson에서 제공하는 JsonParser를 사용하여 json 데이터를 파싱,
        // JsonElement 객체로 반환
        JsonElement jele = JsonParser.parseString(json);

        // 파싱된 결과인 JsonElement 객체에서 JsonObject 타입으로 변환
        JsonObject jobj = jele.getAsJsonObject();

            // 'no':1
        // 변환된 데이터인 JsonObject 객체에서 최상위 요소 중,
        // key에 대한 value의 literal 데이터를 출력
        long no = jobj.get("no").getAsLong();
        System.out.println("no : " + no);



            // 'students':['박병찬','최종수']
        // 변환된 데이터인 JsonObject 객체에서 최상위 요소 중,
        // key에 대한 value가 JsonArray인 데이터를 출력
        JsonArray stdArr = jobj.get("students").getAsJsonArray();
        // JsonArray 타입에 저장된 모든 데이터를 반복문으로 출력
        for (int i = 0; i < stdArr.size(); i++) {
            String name = stdArr.get(i).getAsString();
            System.out.println("학생[" + (i+1) + "] : " + name);
        }



            // 'subject':{'name':'java','professor':'lgh'}
        // 변환된 데이터인 JsonObject 객체에서 최상위 요소 중,
        // key에 대한 value가 JsonObject인 데이터를 출력
        JsonObject sjObj = jobj.get("subject").getAsJsonObject();
        // 출력된 JsonObject 타입의 객체에서 원하는 데이터를 출력
        String sjObjName = sjObj.get("name").getAsString();
        String sjobjProfessor = sjObj.get("professor").getAsString();
        System.out.println("과목명 : " + sjObjName);
        System.out.println("담당교수 : " + sjobjProfessor);
    }

}
