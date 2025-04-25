package com.anhtester.Bai7_WebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleNewWindow {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://anhtester.com");

        Thread.sleep(1000);
        driver.switchTo().newWindow(WindowType.TAB);
        //driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(1000);
        driver.navigate().to("https://google.com");
        Thread.sleep(2000);
        driver.quit();
    }
}
