package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class C03_DataProvider extends ReusableMethods {
    @DataProvider
    public Object[][] kullaniciBilgileri(){
        String path = "C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sayfa);
        return  excelUtils.getDataArrayWithoutFirstRow();
    }

    @Test
    public void test01() {
        BlueRentalPage blueRentalPage= new BlueRentalPage();
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        Actions actions = new Actions(Driver.getDriver());
         WebElement secim =blueRentalPage.aracSecimi;
         actions.click(secim).keyDown(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).build().perform();
         actions.click().keyDown(Keys.ESCAPE).perform();
        blueRentalPage.pickUp.sendKeys(ConfigReader.getProperty("aracAlinacakKonum"),
                Keys.TAB,"aracBirakilacakKonum",Keys.TAB,"alinacakTarih",Keys.TAB,"alinacakSaat",Keys.TAB,"teslimTarihi",Keys.TAB,"teslimSaati");
        blueRentalPage.continueReservation.click();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"),Keys.TAB,"fakepass",Keys.ENTER);

        Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());
    }
}
