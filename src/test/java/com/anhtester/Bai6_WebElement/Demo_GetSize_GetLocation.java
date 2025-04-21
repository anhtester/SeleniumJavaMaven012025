package com.anhtester.Bai6_WebElement;

import com.anhtester.Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo_GetSize_GetLocation {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        //Get size of element
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).getSize().height);
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).getSize().width);

        //Get location of element
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).getLocation().getX());
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).getLocation().getY());

        Thread.sleep(2000);
        driver.quit();

    }
}
