package com.bitc.java404;


import com.bitc.java404.DTO.InteriorDTO;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Interior {
    public void interiorList(String fileName){

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

                        System.out.println(value + "번 ");

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

    private String[] fileInfo(String fileName) {
        String[] fileInfo = new String[2];

        File file = new File(fileName);
        String fileFullPath = file.getPath();

        fileInfo[0] = fileFullPath.substring(0, fileFullPath.lastIndexOf("."));
        fileInfo[1] = fileFullPath.substring(fileFullPath.lastIndexOf(".") + 1);

        return fileInfo;
    }



    public void interiorDataInfo(String fileName) throws FileNotFoundException {
        String[] fileInfo = fileInfo(fileName);

        if (fileInfo[1].equals("xlsx")) {
            interiorListParse(new FileInputStream(fileName));
        } else {
            System.out.println("지원하지 않는 파일 형식입니다.");
        }
        interiorListToDB();

    }

    private void interiorListParse(FileInputStream fis) {
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        try {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);

            int rowLength = sheet.getPhysicalNumberOfRows();

            for (int i = 0; i < rowLength; i++) {
                XSSFRow row = sheet.getRow(i);
                InteriorDTO item = new InteriorDTO();

                if (row != null) {
                    int cellLength = row.getPhysicalNumberOfCells();

                    for (int j = 0; j < cellLength; j++) {
                        XSSFCell cell = row.getCell(j);
                        String value = "";

                        if (cell == null) {
                            continue;
                        }
                        else {
                            switch (cell.getCellType()) {
                                case FORMULA:
                                    value = cell.getCellFormula();
                                    break;

                                case STRING:
                                    value = cell.getStringCellValue();
                                    break;

                                case NUMERIC:
                                    value = String.valueOf((int)cell.getNumericCellValue());
                                    break;

                                case BLANK:
                                    value = String.valueOf(cell.getBooleanCellValue());
                                    break;

                                case ERROR:
                                    value = String.valueOf(cell.getErrorCellValue());
                                    break;
                            }
                            switch(j) {

                                case 0:
                                    item.setSeq(Integer.parseInt(value));



                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    private void interiorListToDB() {
    }

}
