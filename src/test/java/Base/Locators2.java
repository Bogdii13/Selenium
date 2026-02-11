package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;


public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String name = "Bogdan";
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
//        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals((driver.findElement(By.tagName("p")).getText()), "You are successfully logged in.");
        System.out.println(driver.findElement(By.xpath("//h2")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + name + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        Thread.sleep(2000);

        driver.quit();
    }

    public static String getPassword(ChromeDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();

        //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray = passwordText.split("'");
        // 0 index - Please use temporary password
        //1 index - rahulshettyacademy' to Login.

        String password = passwordArray[1].split("'")[0];
        // 0 index - rahulshettyacademy
        // 1 index - to Login.

        return password;


    }
}
