package com.bitc.java404;

import com.bitc.java404.DTO.CulturalDTO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExcelToDB {
    // 주어진 엑셀 파일의 내용을 데이터 베이스에 저장하는 프로그램을 작성하세요
    // file : cultural.xlsx
    // create DTO class
    // create DB table(cultural)

    private String[] fileInfo(String fileName) {
        String[] fileInfo = new String[2];

        File file = new File(fileName);
        String fileFullPath = file.getPath();


        fileInfo[0] = fileFullPath.substring(0, fileFullPath.lastIndexOf("."));

        fileInfo[1] = fileFullPath.substring(fileFullPath.lastIndexOf(".") + 1);

        return fileInfo;
    }



    public void culturalDataInfo(String fileName) throws FileNotFoundException {

        String[] fileInfo = fileInfo(fileName);
        List<CulturalDTO> itemList = null;

        if (fileInfo[1].equals("xls")) {

            itemList = culturalListParse(new FileInputStream(fileName));
        }
        else {
            System.out.println("지원하지 않는 파일 형식입니다.");
        }


        culturalListToDB(itemList);
    }


    private List<CulturalDTO> culturalListParse(FileInputStream fis) {

        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;

        List<CulturalDTO> itemList = new ArrayList<>();

        try {

            workbook = new HSSFWorkbook(fis);

            sheet = workbook.getSheetAt(0);


            int rowLength = sheet.getPhysicalNumberOfRows();


            for (int i = 1; i < rowLength; i++) {

                HSSFRow row = sheet.getRow(i);

                CulturalDTO item = new CulturalDTO();

                if (row != null) {

                    int cellLength = row.getPhysicalNumberOfCells();


                    for (int j = 0; j < cellLength; j++) {

                        HSSFCell cell = row.getCell(j);
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


                            switch (j) {
                                case 0:
                                    item.setName(value);
                                    break;

                                case 1:
                                    item.setAddr1(value);
                                    break;

                                case 2:
                                    item.setCare(value);
                                    break;

                                case 3:
                                    item.setCode(value);
                                    break;

                                case 4:
                                    item.setReg_dt(value);
                                    break;

                                case 5:
                                    item.setAge(value);
                                    break;
                                case 6:
                                    item.setType(value);
                                    break;
                                case 7:
                                    item.setCare_tel(value);
                                    break;
                                case 8:
                                    item.setAddr2(value);
                                    break;
                                case 9:
                                    item.setUpd_dt(value);
                                    break;
                                case 10:
                                    item.setLat(value);
                                    break;
                                case 11:
                                    item.setLng(value);
                                    break;

                            }
                        }
                    }
                }

                itemList.add(item);
            }
        } catch (IOException e) {
        }


        return itemList;
    }

    private void culturalListToDB(List<CulturalDTO> itemList) {
        String dbUrl = "jdbc:mysql://localhost:3306/testdb?characterEncoding=utf8&serverTimezone=UTC";
        String dbUser = "java404";
        String dbPass = "java404";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

            String sql = "insert into cultural (name, addr1, care, ";
            sql += "code, reg_dt, age, type, care_tel, addr2, upd_dt, lat, lng ) ";
            sql += "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            pstmt = conn.prepareStatement(sql);

////      PreparedStatement 객체 재사용하는 방법 1
////      List<InteriorDTO> 의 크기만큼 반복하여 데이터 베이스에 입력
//      for (InteriorDTO item : itemList) {
////        PreparedStatement 객체에 데이터 설정
//        pstmt.setInt(1, item.getSeq());
//        pstmt.setString(2, item.getName());
//        pstmt.setString(3, item.getTel());
//        pstmt.setString(4, item.getAddress());
//
////        데이터 베이스에 sql 쿼리문 실행
//        pstmt.executeUpdate();
////        PreparedStatement 객체에 설정된 sql문에 '?'로 입력된 데이터를 초기화 시킴
//        pstmt.clearParameters();
//      }

            //      PreparedStatement 객체 재사용하는 방법 2
            for (CulturalDTO item : itemList) {
                pstmt.setString(1, item.getName());
                pstmt.setString(2, item.getAddr1());
                pstmt.setString(3, item.getCare());
                pstmt.setString(4, item.getCode());
                pstmt.setString(5, item.getReg_dt());
                pstmt.setString(6, item.getAge());
                pstmt.setString(7, item.getType());
                pstmt.setString(8, item.getCare_tel());
                pstmt.setString(9, item.getAddr2());
                pstmt.setString(10, item.getUpd_dt());
                pstmt.setString(11, item.getLat());
                pstmt.setString(12, item.getLng());


//        sql문의 '?' 부분에 데이터를 설정하고 데이터베이스에서 실행할 쿼리문을 순차적으로 실행할 수 있도록 설정
                pstmt.addBatch();
                pstmt.clearParameters();
            }
//        executeBatch() 실행 시 한번에 여러개의 sql 쿼리문을 실행함
//      배치된 내용이 너무 많으면 메모리를 많이 사용하여 오류가 발생할 수 있음
            pstmt.executeBatch();

            System.out.println("데이터 베이스 입력 완료");
        }
        catch (SQLException e) {
            System.out.println("데이터 베이스 사용 중 오류가 발생했습니다.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (pstmt != null) { pstmt.close(); }
                if (conn != null) { conn.close(); }
            }
            catch (Exception e) {}
        }
    }


}
