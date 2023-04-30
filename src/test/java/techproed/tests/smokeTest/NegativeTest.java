package techproed.tests.smokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class NegativeTest {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();

        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"), Keys.TAB,ConfigReader.getProperty("fakepass"));
        Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());


    }
}
