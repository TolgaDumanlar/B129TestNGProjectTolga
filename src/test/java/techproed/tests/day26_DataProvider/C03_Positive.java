package techproed.tests.day26_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class C03_Positive extends ReusableMethods {

    @DataProvider
    public Object[][] kullaniciBilgileri(){
        String path = "C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sayfa);
        return  excelUtils.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "kullaniciBilgileri")
    public void test01(String email, String password){

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        WebElement ddm = blueRentalPage.aracSecimi;
        Select select = new Select(ddm);
        select.selectByVisibleText("Audi Q8");

        blueRentalPage.pickUp.sendKeys("istanbul", Keys.TAB,"Ankara",Keys.TAB,"03.04.2023",Keys.TAB,"1200",Keys.TAB,
                "10.04.2023",Keys.TAB,"1200");
        bekle(3);

        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(email,Keys.TAB,password,Keys.ENTER);
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());
        Driver.closeDriver();

    }
}
