package org.example.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //Implicit wait  - 5 sec time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // <input type="text" placeholder="Username" id="inputUsername" value="">
        driver.findElement(By.id("inputUsername")).sendKeys("test user");
        driver.findElement(By.name("inputPassword")).sendKeys("passworduser");
        driver.findElement(By.className("submit")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("test user");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("email user");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
//        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("email user2");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("email2");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("phone number ");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rahul");
//        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        driver.quit();


    }
}
