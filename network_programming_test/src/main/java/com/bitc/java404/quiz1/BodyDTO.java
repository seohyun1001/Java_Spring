package com.bitc.java404.quiz1;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class BodyDTO {

    private int numOfRows;
    private int pageNo;
    private int totalCount;
    private ItemsDTO items;



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

    @XmlElement(name = "items")
    public ItemsDTO getItems() {
        return items;
    }

    public void setItems(ItemsDTO items) {
        this.items = items;
    }
}
