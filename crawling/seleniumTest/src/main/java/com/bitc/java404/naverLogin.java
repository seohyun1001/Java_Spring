package com.bitc.java404;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class naverLogin {
    private final static String CHROME_DRIVER_ID = "webdriver.chrome.driver";
    private final static String CHROME_DRIVER_PATH = "c:\\chromedriver.exe";
    private WebDriver driver;

    private String url = "https://www.naver.com";

    public void login() throws Exception{

        System.setProperty(CHROME_DRIVER_ID, CHROME_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get(url);

        Thread.sleep(1000);


//        WebElement mainPageLogin = driver.findElement(
//                By.className("MyView-module__link_login___HpHMW"));
        WebElement mainPageLogin = driver.findElement(
                By.xpath("//*[@id=\"account\"]/div/a"));
        mainPageLogin.click();

        Thread.sleep(1000);



        WebElement loginId = driver.findElement(By.id("id"));
        WebElement loginPw = driver.findElement(By.name("pw"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"log.login\"]"));

        loginId.sendKeys("testid");
        Thread.sleep(1000);

        loginPw.sendKeys("testpw");
        Thread.sleep(1000);

        loginBtn.submit();
        Thread.sleep(3000);

        driver.quit();


    }

}
