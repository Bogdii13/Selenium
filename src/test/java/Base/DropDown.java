package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
// TestNG is one of the testing framework

import java.time.Duration;
import java.util.List;

public class DropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //dropdown with select tag
        WebElement staticDropdwon = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select dropdown = new Select(staticDropdwon);
//        dropdown.selectByValue("USD");

        dropdown.selectByIndex(3);
        String text = dropdown.getFirstSelectedOption().getText();
        Thread.sleep(1000);
        System.out.println(text);


        dropdown.selectByValue("AED");
        String text2 = dropdown.getFirstSelectedOption().getText();
        Thread.sleep(1000);
        System.out.println(text2);


        driver.findElement(By.id("divpaxinfo")).click();
        String textoutput = driver.findElement(By.id("divpaxinfo")).getText();
        System.out.println(textoutput);
        Thread.sleep(1000);
//        int i = 1;
//        while (i < 5) {
//            driver.findElement(By.id("hrefIncAdt")).click();//4 times
//            i++;
//        }
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click(); //4 times
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String textoutput2 = driver.findElement(By.id("divpaxinfo")).getText();
        System.out.println(textoutput2);


//         //a[@value='MAA'] - FROM
//        (//a[@value='CJB'])[2] - TO
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='CJB'])[2]")).click(); ////div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CJB']


        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//li/a[.='India']")).click();
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                System.out.println(option.getText());
                option.click();
                break;
            }
        }

//        driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //if is selceted that checkbox -true/false


        driver.quit();


    }

    @Test
    public void Checkbox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //        driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

//        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //if is selceted that checkbox -true/false

        //count the number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());


        driver.findElement(By.id("divpaxinfo")).click();
        String textoutput = driver.findElement(By.id("divpaxinfo")).getText();
        System.out.println(textoutput);
        Thread.sleep(1000);
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click(); // click 4 times = 5 Adult
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");


        driver.quit();

    }


    @Test
    public void Checkbox2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
//        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).getText());

        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
//        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).getText());


        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.quit();
    }

    @Test
    public void Calendar() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected());
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@class=' ']//a[@class='ui-state-default'][normalize-space()='8']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//td[@class=' ']//a[@class='ui-state-default'][normalize-space()='8']")).isDisplayed());


        driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_rbtnl_Trip_1'])[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_rbtnl_Trip_1'])[1]")).isSelected());
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='#'][normalize-space()='8'][1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='#'][normalize-space()='8'][1]")).isDisplayed());
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='17'])[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//a[@href='#'][normalize-space()='17'])[1]")).isDisplayed());

        driver.quit();
    }


}
