package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_Negative extends ReusableMethods {


    @Test
    public void test01() {
        /*

Acceptance Criteria:
Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
Ve giris yapilmadiginda
Hata mesaji almali : Please first login
Giris yapildiginda hata mesaji alınmamalı

         */


        BlueRentalPage blueRentalPage= new BlueRentalPage();
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

        Actions actions = new Actions(Driver.getDriver());
         WebElement secim =blueRentalPage.aracSecimi;
         actions.click(secim).keyDown(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).build().perform();
         actions.click().keyDown(Keys.ESCAPE).perform();

        blueRentalPage.pickUp.sendKeys(ConfigReader.getProperty("aracAlinacakKonum"),
                Keys.TAB,ConfigReader.getProperty("aracBirakilacakKonum"),
                Keys.TAB,ConfigReader.getProperty("alinacakTarih"),
                Keys.TAB,ConfigReader.getProperty("alinacakSaat"),
                Keys.TAB,ConfigReader.getProperty("teslimTarihi"),
                Keys.TAB,ConfigReader.getProperty("teslimSaati"),Keys.ENTER);
        //blueRentalPage.continueReservation.click();
        bekle(3);
        System.out.println(Driver.getDriver().switchTo().alert().getText());
        //Assert.assertEquals(alert,"Please first login");

//        blueRentalPage.login.click();
//        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"),Keys.TAB,"fakepass",Keys.ENTER);

        //Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());
    }
}
