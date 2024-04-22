package com.bitc.java404.ParsingXml.DTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class PharmacyBodyDTO {
    private int numOfRows;
    private int pageNo;
    private int totalCount;
    private PharmacyItemsDTO items;


@XmlElement(name = "numOfRows")
    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @XmlElement(name = "items") // 클래스 형태로 만들어진 변수는 xmlelement 붙여야 함
    public PharmacyItemsDTO getItems() {
        return items;
    }

    public void setItems(PharmacyItemsDTO items) {
        this.items = items;
    }
}
