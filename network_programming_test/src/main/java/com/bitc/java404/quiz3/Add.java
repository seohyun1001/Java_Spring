package com.bitc.java404.quiz3;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Add {

    public void addToFile(String name, String job, String gender) {
        try {
            String filePath = "c:/java404/quiz3_ksh.xlsx";
            FileInputStream inputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int lastRowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(lastRowNum + 1);
            row.createCell(0).setCellValue(lastRowNum + 2); // 자동으로 순번 기록
            row.createCell(1).setCellValue(name);
            row.createCell(2).setCellValue(job);
            row.createCell(3).setCellValue(gender);

            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);

            outputStream.close();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void addEntertainer() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("연예인 " + (i+1) + " 정보 입력 >>");
            System.out.print("이름: ");
            String name = scanner.nextLine();
            System.out.print("직업: ");
            String job = scanner.nextLine();
            System.out.print("성별: ");
            String gender = scanner.nextLine();
            System.out.println("=================================");

            addToFile(name, job, gender);
        }

        System.out.println("데이터 추가 완료");
        scanner.close();
    }

}
