package com.bitc.java404.quiz2.DTO;

import java.util.List;

public class BoxOfficeResultDTO {

    private String boxofficeType;
    private String showRange;
    private String yearWeekTime;
    private List<WeeklyBoxOfficeDTO> weeklyBoxOfficeList;



    public String getBoxofficeType() {
        return boxofficeType;
    }

    public void setBoxofficeType(String boxofficeType) {
        this.boxofficeType = boxofficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public String getYearWeekTime() {
        return yearWeekTime;
    }

    public void setYearWeekTime(String yearWeekTime) {
        this.yearWeekTime = yearWeekTime;
    }

    public List<WeeklyBoxOfficeDTO> getWeeklyBoxOfficeList() {
        return weeklyBoxOfficeList;
    }

    public void setWeeklyBoxOfficeList(List<WeeklyBoxOfficeDTO> weeklyBoxOfficeList) {
        this.weeklyBoxOfficeList = weeklyBoxOfficeList;
    }
}
