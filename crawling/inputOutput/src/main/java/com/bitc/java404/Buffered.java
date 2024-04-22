package com.bitc.java404;

import java.io.*;

public class Buffered {
    public void inputStreamEx() throws  Exception{
        // example.jpg 파일을 읽어옴
        FileInputStream fis1 = new FileInputStream("C:/java404/example.jpg");

        // 시작 시간 설정
        long start = System.currentTimeMillis();

        // 파일 내용 읽기(read로 1byte씩)
        while (fis1.read() != -1) {
        }

        // 종료 시간 설정
        long end = System.currentTimeMillis();

        // 파일의 내용을 모두 읽는 데 걸린 시간
        System.out.println("사용하지 않았을 경우 : " + (end - start) + "ms");
        fis1.close();
    }



    public void bufInputStreamEx() throws Exception {
        // FileInputStream으로 example.jpg 파일을 읽음
        FileInputStream fis2 = new FileInputStream("C:/java404/example.jpg");
        // 가져온 파일을 BufferdInputStream 클래스 타입의 객체에 저장
        BufferedInputStream bis2 = new BufferedInputStream(fis2);

        // 시작 시간 설정
        long start = System.currentTimeMillis();

        // 파일 내용 읽기(read로 1byte씩)
        while (bis2.read() != 1) {
        }

        // 종료 시간 설정
        long end = System.currentTimeMillis();

        // 파일의 내용을 모두 읽는 데 걸린 시간
        System.out.println("사용했을 경우 : "  + (end - start) + "ms");
        bis2.close();
        fis2.close();
    }



    public void buffReaderEx() throws  Exception{
        // 키보드 입력 받기
        // InputStream : 데이터를 1byte씩 받음
        InputStream is = System.in;

        // InputStreamReader의 생성자에 InputStream 객체를 사용
        // -> 한 문자씩 읽어오는 형태로 변환됨
        Reader reader = new InputStreamReader(is);

        // -> 'reader'를 BufferedReader에 입력하여 사용
        BufferedReader br = new BufferedReader(reader);
        // -> 입력 속도가 빨라짐

        System.out.println("입력 : ");
        String lineString = br.readLine();

        System.out.println("출력 : " + lineString);
    }
}
