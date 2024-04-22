package com.bitc.java404.quiz4;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class DaumNews {

    public void newsParsing(String url, String csvFile) {

        Document html = null;

        try {
            Connection.Response resp = Jsoup.connect(url).method(Connection.Method.GET).execute();

            html = resp.parse();

        } catch (IOException e) {
            System.out.println("Error in Parsing data");
            e.printStackTrace();
        }

        Element listNewsIssue = html.select(".list_newsissue").first();

        Elements item_issue = listNewsIssue.select(".item_issue");

        for (int i = 0; i < item_issue.size(); i++) {

            Element item = item_issue.get(i);

            Element newsATag = item.select(".link_txt").first();
            String newsTitle = newsATag.text();
            String newsLink = newsATag.attr("href");
            System.out.println("newsTitle: " + newsTitle);
            System.out.println("newsLink: " + newsLink);
            System.out.println("===========================================");

        }

        try {
            FileWriter writer = new FileWriter(csvFile);

            // CSV 파일 헤더 작성
            writer.append("News Title, News Link\n");

            // 데이터 추출 및 CSV 파일에 쓰기
            for (int i = 0; i < item_issue.size(); i++) {
                Element item = item_issue.get(i);
                Element newsATag = item.select(".link_txt").first();
                String newsTitle = newsATag.text();
                String newsLink = newsATag.attr("href");

                // CSV 파일에 데이터 작성
                writer.append(newsTitle).append(",").append(newsLink).append("\n");
            }

            writer.close();
            System.out.println("CSV 파일에 데이터가 성공적으로 저장되었습니다.");

        } catch (IOException e) {
            System.out.println("Error in Saving CSV");
            e.printStackTrace();
        }

    }

}
