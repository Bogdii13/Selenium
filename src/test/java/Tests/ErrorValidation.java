package Tests;

import POM.CartPage;
import POM.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {

    @Test(groups = {"ErrorLogin"}, retryAnalyzer = Retry.class)
    public void loginValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";
        //Login
        landingPage.loginAplication("0bogdanionutsas13@gmail.com", "0Bogdan13#");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
    }

    @Test
    public void cartProductsEmpty() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginAplication("bogdanionutsas@gmail.com", "Bogdan13#");
        List<WebElement> products = productCatalogue.getProductList();
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.verifyCart(productName);
        Assert.assertFalse(match);
    }

}
