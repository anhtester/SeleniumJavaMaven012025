package com.anhtester.Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class HandleListElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        // Get all elements menu
        List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@id='side-menu']/li[contains(@class, 'menu-item')]"));

        System.out.println(listMenu.size());

        for (int i = 0; i < listMenu.size(); i++) {
            System.out.println("Menu " + (i + 1) + ": " + listMenu.get(i).getText());
        }

        System.out.println(listMenu.get(0).getText().equals("Home"));
        System.out.println(listMenu.get(1).getText().equals("Customers"));

        driver.quit();
    }
}
