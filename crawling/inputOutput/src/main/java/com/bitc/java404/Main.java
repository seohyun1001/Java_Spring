package com.bitc.java404;

public class Main {
    public static void main(String[] args) {
//        JavaInputStream jis = new JavaInputStream();
//        try {
//            jis.read1();
//        } catch (IOException e){
//            System.out.println("파일을 읽는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



//        JavaInputStream jis2 = new JavaInputStream();
//        try {
//            jis2.read2();
//        } catch (IOException e) {
//            System.out.println("파일을 읽는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



//        JavaInputStream jis3 = new JavaInputStream();
//        try {
//            jis3.read3();
//        } catch (IOException e) {
//            System.out.println("파일을 읽는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



//        JavaOutputStream jos1 = new JavaOutputStream();
//        try {
//            jos1.write1("C:/java404/testwrite1.txt");
//        } catch (IOException e) {
//            System.out.println("파일에 쓰는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



//        JavaOutputStream jos2 = new JavaOutputStream();
//        try {
//            jos2.write2("C:/java404/testwrite2.txt");
//        } catch (IOException e) {
//            System.out.println("파일에 쓰는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



//        JavaOutputStream jos3 = new JavaOutputStream();
//        try {
//            jos3.write3("C:/java404/testwrite3.txt");
//        } catch (IOException e) {
//            System.out.println("파일에 쓰는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



        // quiz1
//        StreamQuiz sq1 = new StreamQuiz();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("파일의 전체 경로 및 이름 입력 >>");
//        String filename = scanner.next();
//        try {
//            sq1.quiz1(filename);
//        } catch (IOException e) {
//            System.out.println("파일을 읽는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



        // quiz2
//        StreamQuiz sq2 = new StreamQuiz();
//        try {
//            sq2.quiz2();
//        } catch (IOException e) {
//            System.out.println("파일을 읽는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("파일에 추가할 내용 입력 >>");
//        String moreContent = scanner.nextLine();
//
//        StreamQuiz addCont = new StreamQuiz();
//        try {
//            addCont.addContent(moreContent);
//        } catch (IOException e) {
//            System.out.println("파일에 쓰는 도중 오류가 발생했음");
//            e.printStackTrace();
//        }



        // quiz3
//        Scanner scanner = new Scanner(System.in);



        // read1
//        JavaReader jr = new JavaReader();
//        try {
//            jr.read1();
//        } catch (Exception e) {
//            System.out.println("오류 발생");
//            throw new RuntimeException(e);
//        }



        // read2
//        JavaReader jr2 = new JavaReader();
//        try {
//            jr2.read2("C:/java404/test2.txt");
//        } catch (Exception e) {
//            System.out.println("오류 발생");
//            throw new RuntimeException(e);
//        }



        // read3
//        JavaReader jr3 = new JavaReader();
//        try {
//            jr3.read3("C:/java404/test2.txt");
//        } catch (Exception e) {
//            System.out.println("오류 발생");
//            throw new RuntimeException(e);
//        }



        // write1
//        JavaWriter jw1 = new JavaWriter();
//        try {
//            jw1.write1("C:/java404/test3write1.txt");
//        }catch (Exception e) {
//            System.out.println("오류 발생");
//            throw new RuntimeException(e);
//        }



        // write2
//        JavaWriter jw2 = new JavaWriter();
//        try {
//            jw2.write2("C:/java404/test3write2.txt");
//        }catch (Exception e) {
//            System.out.println("오류 발생");
//            throw new RuntimeException(e);
//        }



        // write3
//        JavaWriter jw3 = new JavaWriter();
//        try {
//            jw3.write3("C:/java404/test3write3.txt");
//        }catch (Exception e) {
//            System.out.println("오류 발생");
//            throw new RuntimeException(e);
//        }



        // write4
//        JavaWriter jw4 = new JavaWriter();
//        try {
//            jw4.write4("C:/java404/test3write4.txt");
//        }catch (Exception e) {
//            System.out.println("오류 발생");
//            throw new RuntimeException(e);
//        }



        // file1
//        try {
//            File file = new File("C:/java404/testfile1.txt");
//
//            if (file.exists()) {
//                System.out.println("파일 존재함");
//            } else {
//                System.out.println("새 파일 생성");
//                file.createNewFile();
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }



//        try {
//            File file = new File("C:/java404");
//            String[] fileList = file.list();
//
//            for (int i = 0; i < fileList.length; i++){
//                System.out.println(fileList[i]);
//            }
//        } catch (Exception e) {
//            throw  new RuntimeException(e);
//        }



        Buffered buf = new Buffered();
        try {
            System.out.println("======= 버퍼 없이 실행 =======");
            buf.inputStreamEx();
            System.out.println("======= 버퍼로 실행 =======");
            buf.bufInputStreamEx();
            System.out.println("======= 키보드 입력을 버퍼로 실행 =======");
            buf.buffReaderEx();
        } catch (Exception e){
        }


    }
}
