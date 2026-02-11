package POM;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
    //PageFactory
    @FindBy(id = "userEmail")
    WebElement userEmails;
    @FindBy(id = "userPassword")
    WebElement PasswordEle;
    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    //constructor -> pt initializare
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductCatalogue loginAplication(String email, String password) {
        userEmails.sendKeys(email);
        PasswordEle.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;

    }

    public String getErrorMessage() {
        waitForElementToLoad(errorMessage);
        return errorMessage.getText();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }

//    WebElement userEmail = driver.findElement(By.id("userEmail"));


}
