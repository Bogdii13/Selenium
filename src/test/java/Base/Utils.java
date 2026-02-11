package Base;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Utils extends BaseTest {

    @Test
    public void openGoogle() {
        driver.get("http://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }
}
