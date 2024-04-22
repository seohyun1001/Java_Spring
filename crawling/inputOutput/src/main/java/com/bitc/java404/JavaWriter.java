package com.bitc.java404;

import java.io.FileWriter;
import java.io.Writer;

public class JavaWriter {
    public void write1(String filename) throws Exception {
        Writer writer = new FileWriter(filename);
        char[] data = "최종수".toCharArray();

        for (int i = 0; i < data.length; i++) {
            writer.write(data[i]);
        }
        writer.flush();
        writer.close();
    }



    public void write2(String filename) throws Exception {
        Writer writer = new FileWriter(filename);
        char[] data = "박병찬".toCharArray();
        writer.write(data);


        writer.flush();
        writer.close();

    }



    public void write3(String filename) throws Exception {
        Writer writer = new FileWriter(filename);
        char[] data = "최종수박병찬전영중".toCharArray();
        writer.write(data,2,3);

        writer.flush();
        writer.close();
    }



    public void write4(String filename) throws Exception {
        Writer writer = new FileWriter(filename);
        String data = "최종수박병찬전영중";
        writer.write(data,2,3);

        writer.flush();
        writer.close();
    }
}
