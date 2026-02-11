package POM;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement totalRow;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> productTitle;


    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyCart(String productName) {
        Boolean match = productTitle.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout() {
        totalRow.click();
        return new CheckoutPage(driver);
    }
}
