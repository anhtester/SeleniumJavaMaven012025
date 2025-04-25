package com.anhtester.Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBasicMethod {
    public static void main(String[] args) throws InterruptedException {

//        WebDriver driver = new EdgeDriver();
//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(50, 50));
        driver.manage().window().setSize(new Dimension(1300, 800));

        //driver.get("https://anhtester.com");
        driver.navigate().to("https://anhtester.com");
        Thread.sleep(1000);
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);

        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Source: ");
        System.out.println(driver.getPageSource());

        System.out.println("=========================");
        System.out.println(driver.getPageSource().contains("Login | Anh Tester Blog"));

        driver.quit();
    }
}
