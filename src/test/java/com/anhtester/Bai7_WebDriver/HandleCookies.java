package com.anhtester.Bai7_WebDriver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleCookies {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/");
        Thread.sleep(2000);

        // Add a cookie
        driver.manage().addCookie(new Cookie("sp_session", "i6a01dojgujflknpaf84s0g29c5po5so"));

        driver.get("https://crm.anhtester.com/admin/");
        driver.navigate().refresh();

        Thread.sleep(2000);

        driver.quit();
    }
}
