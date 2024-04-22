package com.bitc.java404;

import java.io.*;

public class StreamQuiz {
    // 문제 1) 사용자 입력을 통해서 파일 이름을 입력받고
    // 해당 파일의 내용을 화면에 출력하는 프로그램
    // 파일명 : quiz1.txt / 내용은 영어로 아무거나 입력
    public void quiz1(String filename) throws IOException {
            InputStream is = new FileInputStream(filename);
            int readByteNo;
            byte[] readBytes = new byte[10];
            String data = "";

            while (true) {
                readByteNo = is.read(readBytes);
                if (readByteNo == -1){
                    break;
                }
                data += new String(readBytes, 0, readByteNo);
            }
            System.out.println(data);
            is.close();
        }



    // 문제 2) 기존에 존재하는 파일을 열고 사용자 입력을 통해서 입력받은 내용을
    // 기존 파일의 뒤에 추가하는 프로그램
    // 파일명 : quiz2.txt / 원본 내용 : network programming
    public void quiz2() throws IOException{
        InputStream is = new FileInputStream("C:/java404/quiz2.txt");
        int readByteNo;
        byte[] readBytes = new byte[1024];
        String data = "";

        while (true) {
            readByteNo = is.read(readBytes);
            if (readByteNo == -1){
                break;
            }
            data += new String(readBytes, 0, readByteNo);
        }
        System.out.println("Original Data : " + data);
        is.close();
    }

    public void addContent(String content) throws IOException {
        InputStream is = new FileInputStream("C:/java404/quiz2.txt");
        int readByteNo;
        byte[] readBytes = new byte[1024];
        String originData = "";

        while (true) {
            readByteNo = is.read(readBytes);
            if (readByteNo == -1){
                break;
            }
            originData += new String(readBytes, 0, readByteNo);
        }
        OutputStream os = new FileOutputStream("C:/java404/quiz2.txt");
        byte[] data1 = originData.getBytes();
        byte[] data2 = content.getBytes();
        os.write(data1);
        os.write(data2);
        os.flush();
        os.close();
        is.close();
    }



    // 문제 3) 사용자 입력을 통해서 원본 파일의 이름과 사본 파일의 이름을 입력받고
    // 원본 파일의 내용을 사본 파일에 저장하는 프로그램
    // 원본 파일명 : quiz3.txt
    // 원본 내용 : network programming quiz3
    // 사본 파일명 : quiz3_copy.txt
    public void quiz3(String filename) throws IOException {
        InputStream is = new FileInputStream("C:/java404/quiz3.txt");
        int readByteNo;
        byte[] readBytes = new byte[1024];
        String data1 = "";

        while (true) {
            readByteNo = is.read(readBytes);
            if (readByteNo == -1) {
                break;
            }
            data1 += new String(readBytes, 0, readByteNo);
        }
        is.close();
        OutputStream os = new FileOutputStream(filename);
        // byte[] 배열에 저장된 데이터를 파일에 쓰기
        byte[] data2 = filename.getBytes();
        // write(byte[] buff)를 사용하여 byte[] 배열에 저장된 내용을 한번에 쓰기
        os.write(data2);
        // 버퍼에 저장된 내용을 파일에 쓰기
        os.flush();
        // 파일 닫기
        os.close();
    }
}
