package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.security.Key;

public class C03_NegativeTekrar {


    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();

        WebElement secim =blueRentalPage.aracSecimi;
        Select options = new Select(secim);
        options.selectByVisibleText("Audi Q8");

        blueRentalPage.pickUp.sendKeys(ConfigReader.getProperty("aracAlinacakKonum"),
                Keys.TAB, ConfigReader.getProperty("aracBirakilacakKonum"),
                Keys.TAB, ConfigReader.getProperty("alinacakTarih"),
                Keys.TAB, ConfigReader.getProperty("alinacakSaat"),
                Keys.TAB,ConfigReader.getProperty("teslimTarihi"),
                Keys.TAB,ConfigReader.getProperty("teslimSaati"),Keys.ENTER);

        Assert.assertTrue(blueRentalPage.uyariMesaji.isDisplayed());


    }
}
