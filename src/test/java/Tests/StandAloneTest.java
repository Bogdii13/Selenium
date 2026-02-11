package Tests;

import POM.*;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class StandAloneTest extends BaseTest {
    String productName1 = "ZARA COAT 3";
    String productName2 = "ADIDAS ORIGINAL";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

        //Login
        ProductCatalogue productCatalogue = landingPage.loginAplication(input.get("email"), input.get("password"));

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();


        Boolean match = cartPage.verifyCart(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("Romania");
        ConfirmationPage confirmationPage = checkoutPage.submit();
        confirmationPage.setHeroPrimary();
    }

    @Test(dependsOnMethods = "submitOrder")
    public void orderHistory() throws IOException, InterruptedException {
        ProductCatalogue productCatalogue = landingPage.loginAplication("bogdanionutsas13@gmail.com", "Bogdan13#");
        OrderPage orderPage = productCatalogue.orderPage();
        Assert.assertTrue(orderPage.verifyOrder(productName1));
    }


    @DataProvider
    public Object[][] getData() throws IOException {
//        HashMap<String, String> map = new HashMap();
//        map.put("email", "bogdanionutsas13@gmail.com");
//        map.put("password", "Bogdan13#");
//        map.put("productName", productName1);
//
//        HashMap<String, String> map1 = new HashMap();
//        map1.put("email", "bogdanionutsas@gmail.com");
//        map1.put("password", "Bogdan13#");
//        map1.put("productName", productName2);

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + ("/src/test/java/data/PurchaseOrder.json"));
        return new Object[][]{{data.get(0)}, {data.get(1)}};

    }


}


