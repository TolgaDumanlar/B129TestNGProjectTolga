package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C02_ExcelTest2 {
    @Test
    public void test01() {
        String path ="C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sayfa);

        //Bluerantal car adresine gidelim.
        //Excel dosyamızdan aldıgımız ılk emaıl ve password ıle sayfaya login olalım.

        String email =excelUtils.getCellData(1,0);
        String password=excelUtils.getCellData(1,1);
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

        BlueRentalPage blueRentalPage =new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email,Keys.TAB,password, Keys.ENTER);

        //Login oldugumuzu dogrulyalım
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());

    }
}
