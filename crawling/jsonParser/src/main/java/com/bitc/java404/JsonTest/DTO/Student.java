package com.bitc.java404.JsonTest.DTO;

public class Student {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String toString() {
        return "Student [no = " + no + ", name = " + name + "]";
    }
}
