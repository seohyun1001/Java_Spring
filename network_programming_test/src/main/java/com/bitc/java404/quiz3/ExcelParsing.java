package com.bitc.java404.quiz3;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelParsing {

    public void entertainerList(String fileName) {

        InputStream fis = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;

        try {

            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);

            int rowNo = 0;
            int cellNo = 0;

            int rowLength = sheet.getPhysicalNumberOfRows();

            for (rowNo = 0; rowNo < rowLength; rowNo++) {
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
