package com.bitc.java404.plusDTO;

public class Main {
    public static void main(String[] args) {


        // add data
        memberDTO member = new memberDTO();
//        member.setUser_id("test4");
//        member.setUser_name("tester4");
//        member.setUser_pw("1234");
//        member.setUser_email("testuser4@naver.com");
//        member.setUser_phone("01010011231");
//        member.setUser_addr("incheon");

        memberDAO dao = new memberDAO();

//        System.out.println("======= confirm existed user info =======");
//        dao.selectDB();
//        System.out.println("======= add user =======");
//        dao.insertDB(member);
//        System.out.println("======= confirm whole info after adding user 'tester4' =======");
//        dao.selectDB();

//        member.setUser_id("test5");
//        member.setUser_name("tester5");
//        member.setUser_pw("1234");
//        member.setUser_email("testuser5@naver.com");
//        member.setUser_phone("01012311001");
//        member.setUser_addr("seoul");
//
//        System.out.println("======= add user 'tester5' =======");
//        dao.insertDB(member);
//        System.out.println("======= confirm whole info after adding user 'tester5' =======");
//        dao.selectDB();


        System.out.println("======= revising data =======");

        member.setUser_id("test5");
        member.setUser_name("user5");
        member.setUser_pw("1234567890");
        member.setUser_email("user5@naver.com");
        member.setUser_phone("01012311001");
        member.setUser_addr("seoul");

        dao.updateDB(member);

        System.out.println("======= output whole data after revising =======");

        dao.selectDB();

    }
}
