package com.anhtester.Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleCookies_Login {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000);

        //Lấy cookie trong lần đăng nhập đầu tiên
        Cookie cookieValue = driver.manage().getCookieNamed("sp_session");

        driver.quit();

        //Dùng lại cookie cho lần mở trình duyệt tiếp theo
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver2.get("https://crm.anhtester.com/admin/");
        Thread.sleep(2000);
        // Add a cookie
        System.out.println(cookieValue.getName());
        System.out.println(cookieValue.getValue());
        driver2.manage().addCookie(new Cookie(cookieValue.getName(), cookieValue.getValue()));

        driver2.get("https://crm.anhtester.com/admin/");
        driver2.navigate().refresh();
        Thread.sleep(2000);
        // Delete all cookies
        driver2.manage().deleteAllCookies();
        driver2.navigate().refresh();

        Thread.sleep(2000);

        driver2.quit();
    }
}
