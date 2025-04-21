package com.anhtester.Bai6_WebElement;

import com.anhtester.Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo_isDisplayed_isEnabled_isSelected {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

        //Handle isDisplayed
        boolean checkHeaderLoginPageDisplayed = driver.findElement(By.xpath(LocatorsCRM.headerLoginPage)).isDisplayed();
        System.out.println("checkHeaderLoginPageDisplayed: " + checkHeaderLoginPageDisplayed);

        Thread.sleep(2000);

        //Handle isSelected
        boolean checkCheckboxRememberMeSelected = driver.findElement(By.xpath(LocatorsCRM.checkboxRememberMe)).isSelected();
        System.out.println("checkCheckboxRememberMeSelected: " + checkCheckboxRememberMeSelected);

        driver.findElement(By.xpath(LocatorsCRM.labelRememberMe)).click();
        Thread.sleep(1000);

        boolean checkCheckboxRememberMeSelected_After = driver.findElement(By.xpath(LocatorsCRM.checkboxRememberMe)).isSelected();
        System.out.println("checkCheckboxRememberMeSelected_After: " + checkCheckboxRememberMeSelected_After);


        Thread.sleep(2000);
        //Handle isEnabled
        driver.get("https://angular-reactive-forms-zvzqvd.stackblitz.io/");
        driver.findElement(By.xpath("//span[normalize-space()='Run this project']")).click();
        Thread.sleep(3000);

        boolean checkButtonSubmitDisplayed = driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isDisplayed();
        System.out.println("checkButtonSubmitDisplayed: " + checkButtonSubmitDisplayed);

        boolean checkButtonSubmitEnable = driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isEnabled();
        System.out.println("checkButtonSubmitEnable: " + checkButtonSubmitEnable);

        driver.quit();

    }
}
