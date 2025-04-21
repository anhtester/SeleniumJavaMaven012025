package com.anhtester.Bai6_WebElement;

import com.anhtester.Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo_GetText_GetCssValue_GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");

        //Get attribute value
        String attributeValueEmail = driver.findElement(By.xpath(LocatorsCRM.inputEmail)).getAttribute("value");
        System.out.println("Attribute value Email: " + attributeValueEmail);

        String attributeValuePassword = driver.findElement(By.xpath(LocatorsCRM.inputPassword)).getAttribute("value");
        System.out.println("Attribute value Password: " + attributeValuePassword);

        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");

        //driver.findElement(By.xpath(LocatorsCRM.inputPassword)).submit();

        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        Thread.sleep(2000);
        String headerCustomersText = driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).getText();
        System.out.println("Header Customers: " + headerCustomersText);

        if (headerCustomersText.equals("Customers Summary")) {
            System.out.println("Header Customers is correct");
        }

        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Active Customers']/preceding-sibling::span")).getText());
        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Active Customers']/preceding-sibling::span")).getTagName());

        //Get css value
        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Active Customers']")).getCssValue("color"));
        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Active Customers']")).getCssValue("font-family"));
        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Active Customers']")).getCssValue("font-size"));

        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='Inactive Customers']")).getCssValue("color"));

        Thread.sleep(2000);
        driver.quit();

    }
}
