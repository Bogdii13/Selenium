package POM;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;
    @FindBy(css = "[placeholder='Select Country']")
    WebElement country;

    @FindBy(css = ".action__submit")
    WebElement submit;

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    WebElement selectedCountry;

    By results = By.cssSelector(".ta-results");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String countryName) {
        Actions actions = new Actions(driver);
        actions.sendKeys(country, countryName).build().perform();
        waitForElementToLoad(results);
        selectedCountry.click();
    }

    public ConfirmationPage submit() {
        submit.click();
        return new ConfirmationPage(driver);
    }

}
