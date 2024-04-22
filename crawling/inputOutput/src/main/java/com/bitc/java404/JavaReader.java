package com.bitc.java404;

import java.io.FileReader;
import java.io.Reader;

public class JavaReader {
    // InputStream : 1byte씩 읽음
    // Reader : 유니코드 문자로 읽음 -> 문자를 읽어야 할 때는 reader/writer로 읽는게 좋다
    public void read1() throws Exception {
        // 문자를 읽어오는 Reader 클래스를 사용하여 파일을 열기
        // Reader 클래스는 추상 클래스이므로 Reader 클래스를 상속받은
        // FileReader 클래스 타입의 객체를 Reader 타입의 변수에 저장하여 사용함
        Reader reader = new FileReader("C:/java404/test2.txt");
        int readData;

        while (true) {
            readData = reader.read();
            if (readData == -1) {
                break;
            }
            // 읽어온 데이터가 int 타입이기 때문에 char을 사용하여 강제 타입 변환
            System.out.print((char) readData);
        }
        // Reader도 외부 리소스이기 때문에 사용 후 반드시 닫아줘야 함
        reader.close();
    }



    // read(char{} cbuff)
    public void read2(String filename) throws Exception {
        Reader reader = new FileReader(filename);
        // 읽어온 문자의 수를 저장할 변수
        int readCharNo;

        // 읽어온 데이터를 저장할 char[] 배열
        char[] cbuff = new char[2];

        // 읽어온 데이터를 문자열로 출력하기 위한 변수
        String data = "";

        // 반복문을 통해서 파일의 내용을 계속 읽어옴
        while (true) {
            // 지정한 char[]배열의 크기만큼 파일에서 문자를 읽어옴
            readCharNo = reader.read(cbuff);
            if (readCharNo == -1) {
                break;
            }
            // 읽어온 데이터를 String 타입으로 변환 후 저장
            data += new String(cbuff, 0, readCharNo);
        }
        System.out.println(data);
        reader.close();
    }



    public void read3(String filename) throws Exception {
        Reader reader = new FileReader(filename);
        int readCharNo;
        // 파일에서 읽어온 데이터를 저장할 char[]배열
        char[] cbuff = new char[4];
        // 파일에서 데이터를 읽어와 지정한 배열에 저장 시
        // offset으로 지정한 위치에 length 크기만큼 저장함
        readCharNo = reader.read(cbuff, 1, 2);
        // -> char[4] : [0 1 2 3] 4칸짜리 배열에
        // offset(1) : index번호 1번부터
        // length(2) : 2개를 집어 넣는다

        for (int i = 0; i < cbuff.length; i++) {
            System.out.print(cbuff[i]);
        }
        reader.close();
    }
}
