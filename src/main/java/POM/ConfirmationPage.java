package POM;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponent {
    WebDriver driver;
    @FindBy(css = ".hero-primary")
    WebElement heroPrimary;

    By message = By.cssSelector(".hero-primary");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setHeroPrimary() {
        waitForElementToLoad(message);
        heroPrimary.getText();
        isDisplayed(message);
    }
}