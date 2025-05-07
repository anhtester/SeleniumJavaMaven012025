package com.anhtester.Bai8_Checkbox_Radio_Dropdown;

import com.anhtester.Bai5_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckbox {

    public static void handleCheckbox1() throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/checkbox");

        //Click chọn checkbox/ tháo ra
        driver.findElement(By.xpath("//label[@for='tree-node-home']")).click();
        System.out.println("Checkbox Home is selected");
        Thread.sleep(2000);

        //Kiểm tra checkbox đã được chọn hay chưa
        boolean isSelected = driver.findElement(By.xpath("//input[@id='tree-node-home']")).isSelected();
        System.out.println("Checkbox Home is selected: " + isSelected);

        driver.findElement(By.xpath("//label[@for='tree-node-home']")).click();
        System.out.println("Checkbox Home is unselected");

        //Kiểm tra checkbox đã được chọn hay chưa
        boolean isSelected2 = driver.findElement(By.xpath("//input[@id='tree-node-home']")).isSelected();
        System.out.println("Checkbox Home is selected: " + isSelected2);

        driver.quit();
    }

    public static void handleCheckbox2() throws InterruptedException {
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

        driver.findElement(By.xpath("//div[normalize-space()='Dashboard Options']")).click();

        Thread.sleep(2000);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='dashboard-options']//input[@type='checkbox']"));

        System.out.println("Total checkboxes: " + checkboxes.size());

        boolean check = false;

        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                System.out.println("Checkbox " + (i + 1) + " is selected");
                check = true;
            } else {
                System.out.println("Checkbox " + (i + 1) + " is not selected");
                check = false;
                break; //Thoát khỏi vòng lặp nếu checkbox không được chọn

//                checkboxes.get(i).click();
//                System.out.println("Checkbox " + (i + 1) + " is now selected");
            }
        }

        System.out.println(check);

        Thread.sleep(1000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {

        //handleCheckbox1();
        handleCheckbox2();
    }
}
