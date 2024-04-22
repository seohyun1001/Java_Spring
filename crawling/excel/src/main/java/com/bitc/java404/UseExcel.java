package com.bitc.java404;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class UseExcel {

    // Apache POI : library made by apache software association
    // serve functions read and write file of os in java
    // poifs : ms office의 ole2 포맷 방식을 사용하는 클래스
    // 모든 오피스 파일 포맷을 ole2 방식을 사용함
    // * hssf : ms office excel 97 버전 포맷 방식(.xls)의 엑셀 파일을 컨트롤 할 때 사용하는 클래스
    // * xssf : ms office excel 2007 버전 포맷 방식(.xlsx)의 엑셀 파일을 컨트롤 할 때 사용하는 클래스
    // * sxssf : xssf의 스트리밍 버전 대용량 엑셀 파일을 다룰 경우 사용
    // 대용량 엑셀 파일 사용 시 임시 파일을 생성하면서 사용할 수 있음
    // * hpsf : 오피스 파일의 문서 요약 정보 읽기
    // hwpf : 워드 파일 컨트롤 시 사용(.doc)
    // hslf : 파워 포인트 컨트롤 시 사용
    // hpbf : 퍼블리셔 파일 컨트롤 시 사용
    // hsmf : 아웃룩의 msg 파일을 컨트롤 시 사용
    // ddf : 오피스에서 사용하는 이미지 파일을 컨트롤 시 사용



    public void readExcel(String fileName) {
        try {
            // read excel flie by inputStream
            // not the general text file, use inputstream
            FileInputStream fis = new FileInputStream(fileName);

            // workbook class served by xssf, means excel file
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            // the variable receive excel row number
            int rowNo = 0;
            // the variable receive excel column number
            int cellNo = 0;

            // the sheet served by XSSF way. create the class object
            // getSheetAt(sheet munber) : bring the sheet selected number
            XSSFSheet sheet = workbook.getSheetAt(0);
            // getPhysicalNumberOfRows() : notice location of row the content inputted by user
            int rows = sheet.getPhysicalNumberOfRows();

            for (rowNo = 0; rowNo <= rows; rowNo++) {
                // create row class object(served by xssf)
                // getRow(row 번호) : bring the row object selected index
                // when not data inputted by user, output 'null';
                XSSFRow row = sheet.getRow(rowNo);

                // when only data exist, then act
                if (row != null) {
                    // getPhysicalNumberOfCells() : return the location of cell inputted by user
                    int cells = row.getPhysicalNumberOfCells();

                    for (cellNo = 0; cellNo <= cells; cellNo++) {
                        // create the cell class object(served by xssf way)
                        // getCell(cell number) : bring the cell object saved in the selected index
                        // when not data inputted by user, then return null
                        XSSFCell cell = row.getCell(cellNo);
                        // the variable save the data inputted in cell
                        String value = "";

                        // when the data is not existing, then go on to the next cell using continue
                        if (cell == null) {
                            continue;
                        }
                        else {
                            // when the data exist, then bring the data
                            // divide the data type of saved in the content
                            switch (cell.getCellType()) {
                                // when the data saved by expression
                                case FORMULA:
                                    value = cell.getCellFormula();
                                    break;

                                // when the data saved by number
                                case NUMERIC:
                                    value = String.valueOf(cell.getNumericCellValue());
                                    break;

                                // when the data saved by character
                                case STRING:
                                    value = cell.getStringCellValue();
                                    break;

                                // when the data saved by logical
                                case BLANK:
                                    value = String.valueOf(cell.getBooleanCellValue());

                                    // when the error occur
                                case ERROR:
                                    value = String.valueOf(cell.getErrorCellValue());
                            }
                        }
                        System.out.println((rowNo+1) + "행 " + (cellNo+1) + "칸의 값 : " + value);
                    }
                }
            }
        }
        catch (Exception e) {

        }
    }
}














