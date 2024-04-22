package com.bitc.java404;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ExcelParsing {
    // 제공된 xls 엑셀 파일을 poi 라이브러리를 사용하여 엑셀 파일의 내용을
    // 화면에 모두 출력하는 프로그램을 작성하세요
    // ps. 제공된 엑셀 파일이 xls인지 xlsx인지를 구분하는 소스 코드를 추가하여 작성
    // -> File 클래스 사용
    // ps. 사용자 키보드 입력을 통해서 파일명(파일 전체 경로)을 입력 받아서 사용
    // ps. 확장자 xls이면 HSSF 사용, xlsx면 XSSF 사용

    public void parsingExcel() {
        ExcelParsing xls = new ExcelParsing();
        ExcelParsing xlsx = new ExcelParsing();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the whole file name >>");
        String fileName = sc.nextLine();

        if (fileName.endsWith(".xlsx")) {
            xlsx.excelListXSSF(fileName);
        } else if (fileName.endsWith(".xls")) {
            xls.excelListHSSF(fileName);
        }
    }

    public void excelListHSSF(String fileName){

        InputStream fis = null;
        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;

        try {

            fis = new FileInputStream("C:/java404/" + fileName);
            workbook = new HSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);

            int rowNo = 0;
            int cellNo = 0;

            int rowLength = sheet.getPhysicalNumberOfRows();

            for (rowNo = 1; rowNo < rowLength; rowNo++) {
                HSSFRow row = sheet.getRow(rowNo);

                if (row != null) {
                    int cellLength = row.getPhysicalNumberOfCells();

                    for (cellNo = 0; cellNo < cellLength; cellNo++) {
                        HSSFCell cell = row.getCell(cellNo);
                        String value = "";

                        if (cell == null) {
                            continue;
                        } else {
                            switch (cell.getCellType()) {
                                case FORMULA :
                                    break;

                                case NUMERIC:
                                    value = String.valueOf((int) cell.getNumericCellValue());
                                    break;

                                case STRING :
                                    value = cell.getStringCellValue();
                                    break;

                                case BLANK :
                                    value = String.valueOf(cell.getBooleanCellValue());
                                    break;

                                case ERROR :
                                    value = String.valueOf(cell.getErrorCellValue());
                                    break;
                            }
                        }

                        System.out.println(value);

                    }
                }

                System.out.println("===========================================");

            }

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            try {
                if (workbook != null) {workbook.close();}
                if (fis != null) {fis.close();}
            } catch (Exception e){}
        }
    }



    public void excelListXSSF(String fileName){

        InputStream fis = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        try {

            fis = new FileInputStream("C:/java404/" + fileName);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);

            int rowNo = 0;
            int cellNo = 0;

            int rowLength = sheet.getPhysicalNumberOfRows();

            for (rowNo = 1; rowNo < rowLength; rowNo++) {
                XSSFRow row = sheet.getRow(rowNo);

                if (row != null) {
                    int cellLength = row.getPhysicalNumberOfCells();

                    for (cellNo = 0; cellNo < cellLength; cellNo++) {
                        XSSFCell cell = row.getCell(cellNo);
                        String value = "";

                        if (cell == null) {
                            continue;
                        } else {
                            switch (cell.getCellType()) {
                                case FORMULA :
                                    break;

                                case NUMERIC:
                                    value = String.valueOf((int) cell.getNumericCellValue());
                                    break;

                                case STRING :
                                    value = cell.getStringCellValue();
                                    break;

                                case BLANK :
                                    value = String.valueOf(cell.getBooleanCellValue());
                                    break;

                                case ERROR :
                                    value = String.valueOf(cell.getErrorCellValue());
                                    break;
                            }
                        }

                        System.out.println(value);

                    }
                }

                System.out.println("===========================================");

            }

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            try {
                if (workbook != null) {workbook.close();}
                if (fis != null) {fis.close();}
            } catch (Exception e){}
        }
    }
}
