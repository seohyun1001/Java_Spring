package com.bitc.java404.quiz3;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class SaveExcel {

    public static Workbook readExcel(String filePath) throws Exception {
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();
        return workbook;
    }

    // Workbook 객체를 받아 새로운 엑셀 파일에 데이터를 쓰는 메서드
    public static void writeExcel(Workbook workbook, String filePath) throws Exception {
        Workbook outputWorkbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.getSheetAt(0);
        Sheet outputSheet = outputWorkbook.createSheet(sheet.getSheetName());

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row sourceRow = sheet.getRow(i);
            Row destinationRow = outputSheet.createRow(i);
            if (sourceRow != null) {
                for (int j = 0; j < sourceRow.getLastCellNum(); j++) {
                    Cell sourceCell = sourceRow.getCell(j);
                    Cell destinationCell = destinationRow.createCell(j);
                    if (sourceCell != null) {
                        switch (sourceCell.getCellType()) {
                            case STRING:
                                destinationCell.setCellValue(sourceCell.getStringCellValue());
                                break;
                            case NUMERIC:
                                destinationCell.setCellValue(sourceCell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                destinationCell.setCellValue(sourceCell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                destinationCell.setCellFormula(sourceCell.getCellFormula());
                                break;
                            default:
                                destinationCell.setCellValue(sourceCell.toString());
                        }
                    }
                }
            }
        }

        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputWorkbook.write(outputStream);

        outputStream.close();
        outputWorkbook.close();
    }

}
