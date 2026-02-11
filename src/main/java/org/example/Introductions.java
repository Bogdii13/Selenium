package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introductions {
    public static void main(String[] args) {
        // invoking browser
        //Chrome - ChromeDriver - Methods
//        System.setProperty("webdriver.chrome.webdriver", "/Users/bogdan.sas/Documents/SSelenium/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://m.cinemagia.ro/program-tv/acasa/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();


    }
}
