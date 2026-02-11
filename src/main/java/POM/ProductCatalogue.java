package POM;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;


    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement animating;

    By prodcutsBy = By.cssSelector(".mb-3");
    By addToCartBy = By.cssSelector(".card-body button:last-of-type");
    By toastMess = By.cssSelector("#toast-container");

    //constructor
    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProductList().stream().filter(product ->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName) throws InterruptedException {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCartBy).click();
        waitForElementToLoad(toastMess);
        waitForInvisibilityOfElementLocated(animating);
        goToCartPage();
    }

    public List<WebElement> getProductList() {
        waitForElementToLoad(prodcutsBy);
        return products;
    }


}

