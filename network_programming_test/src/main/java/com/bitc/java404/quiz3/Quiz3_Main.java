package com.bitc.java404.quiz3;

import org.apache.poi.ss.usermodel.Workbook;

public class Quiz3_Main {
    public static void main(String[] args) {

    ExcelParsing quiz3 = new ExcelParsing();
    quiz3.entertainerList("C:/java404/quiz3.xlsx");

        String inputFilePath = "c:/java404/quiz3.xlsx";
        String outputFilePath = "c:/java404/quiz3_ksh.xlsx";

        try {
            Workbook workbook = SaveExcel.readExcel(inputFilePath);
            SaveExcel.writeExcel(workbook, outputFilePath);
        } catch (Exception e) {

        }

    Add add = new Add();
    add.addEntertainer();

    }
}
