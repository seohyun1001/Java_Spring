package com.bitc.java404;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoffeeBean extends WebBase{
    public CoffeeBean() {
        System.setProperty(WebBase.CHROME_DRIVER_ID,WebBase.CHROME_DRIVER_PATH);
        options = chromeOptionSetUp();
        driver = new ChromeDriver(options);
    }

    public ChromeOptions chromeOptionSetUp() {
        ChromeOptions opt = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--remote-allow-origins=*");

        return opt;
    }

    public void getStoreInfo() throws  Exception{
        requestUrl = "https://www.coffeebeankorea.com/store/store.asp";

        driver.get(requestUrl);
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("storePop2('31');");
        Thread.sleep(2000);

        String html = driver.getPageSource();
        driver.quit();

        Document doc = Jsoup.parse(html);
        Element popup_inner = doc.select("div.popup_inner").first();
        Element store_txt = popup_inner.select("div.store_txt").first();

        Element h2 = store_txt.select("h2").first();
        Elements storeInfoList = store_txt.select("td");
        Element showInfoTime = storeInfoList.get(0);
        Element showInfoAddr = storeInfoList.get(2);
        Element showInfoTel = storeInfoList.get(3);

        String storeName = h2.text();
        String storeTime = showInfoTime.text();
        String storeAddr = showInfoAddr.text();
        String storeTel = showInfoTel.text();

        System.out.println("점포명 : " + storeName);
        System.out.println("영업시간 : " + storeTime);
        System.out.println("점포 주소 : " + storeAddr);
        System.out.println("전화번호 : " + storeTel);
        
    }


    public static void main(String[] args) throws Exception{

    }
}
