package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

import java.util.Arrays;

public class C01_DataProviderTest1 {


    @DataProvider()
    public Object[][] customerData(){

        //ExcelUtils Objesi olusturarak
        String path = "C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sayfa);
        return  excelUtils.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "customerData")
    public void testName(String email, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());
        Driver.closeDriver();


    }

}
