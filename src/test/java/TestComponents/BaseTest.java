package TestComponents;

import POM.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected LandingPage landingPage;


    public WebDriver intializerDriver() throws IOException {

        //properties class
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Resources/GoobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        ChromeOptions options = new ChromeOptions();

        if (browserName.equalsIgnoreCase("chrome")) {

            options.addArguments("headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //reade json file to string
        String jsonContet = FileUtils.readFileToString(new File(filePath));

        //string to HasMap - Jackson Datbind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContet, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;

    }

    public String getScreenshot(String testName, WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destinationPath =
                System.getProperty("user.dir")
                        + "/screenshots/"
                        + testName
                        + ".png";

        File destination = new File(destinationPath);
        destination.getParentFile().mkdirs(); // creează folderul dacă nu exista

        FileUtils.copyFile(source, destination);

        return destinationPath;
    }


    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = intializerDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}
