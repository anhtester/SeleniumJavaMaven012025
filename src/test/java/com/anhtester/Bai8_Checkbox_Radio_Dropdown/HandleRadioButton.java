package com.anhtester.Bai8_Checkbox_Radio_Dropdown;

import com.anhtester.Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleRadioButton {

    public static void handleRadioButton1() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/radio-button");

        boolean checkRadio = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();
        System.out.println("Radio Yes is selected: " + checkRadio);

        //Click chọn radio button
        driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();

        boolean checkRadio2 = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();
        System.out.println("Radio Yes is selected: " + checkRadio2);

        Thread.sleep(2000);
        driver.quit();
    }

    public static void handleRadioButton2() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        driver.findElement(By.xpath("//span[@class='menu-text'][normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Proposals']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New Proposal']")).click();

        List<WebElement> radioButtons = driver.findElements(By.xpath("//span[normalize-space()='Show quantity as:']/following-sibling::div//input"));

        System.out.println("Total radio buttons: " + radioButtons.size());

        int check1 = 0;
        int check2 = 0;

        for (int i = 0; i < radioButtons.size(); i++) {
            if (radioButtons.get(i).isSelected()) {
                System.out.println("Radio button " + (i + 1) + " is selected");
                check1++;
            } else {
                System.out.println("Radio button " + (i + 1) + " is not selected");
                check2++;
            }
        }

        System.out.println("Total radio button selected: " + check1);
        System.out.println("Total radio button not selected: " + check2);

        Thread.sleep(2000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        //handleRadioButton1();
        handleRadioButton2();

    }

}
