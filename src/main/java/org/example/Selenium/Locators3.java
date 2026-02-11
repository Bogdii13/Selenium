package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Sibiling - child to parent traverse

        //header/div/button[1]/following-sibling::button[1]
        String login = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println(login);
        String login2 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
        System.out.println(login2);


        Thread.sleep(1000);
        String access = driver.findElement(By.xpath("//a[@class='blinkingText']")).getText();
        System.out.println(access);


        driver.quit();

    }
}
