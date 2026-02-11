package POM;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productTitle;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyOrder(String productName) {
        Boolean match = productTitle.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }
}
