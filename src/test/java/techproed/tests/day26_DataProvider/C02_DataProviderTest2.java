package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;

public class C02_DataProviderTest2 {
    @Test(dataProvider = "sehirVerileri",dataProviderClass = DataProviderUtils.class)
    public void test1(String ad, String bolge, String plaka) {
        System.out.println("Sehir adi :"+ad+", Bolge :"+bolge+", Plaka: "+plaka);
    }

    @Test(dataProvider = "kullaniciBilgileri",dataProviderClass = DataProviderUtils.class)
    public void test2(String username, String password) {
        System.out.println("Kullanici adi :"+username+", Sifre :"+password);
    }

    @Test(dataProvider = "customerData",dataProviderClass = DataProviderUtils.class)
    public void test3(String email, String password) {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        Driver.closeDriver();
    }
}
