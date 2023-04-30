package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C03_ExcelTest3 {
    @Test
    public void test01() {
        /*
EXCEL dosyasindaki tum email ve passwordler ile
BlueRentalCar sayfasina gidip login olalim?
 */
        String path ="C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sayfa);
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

        for (int i = 1; i <=excelUtils.rowCount() ; i++) {
            String email =excelUtils.getCellData(i,0);
            String password=excelUtils.getCellData(i,1);

            BlueRentalPage blueRentalPage = new BlueRentalPage();
            blueRentalPage.login.click();
            blueRentalPage.email.sendKeys(email, Keys.TAB,password, Keys.ENTER);
            blueRentalPage.logOutDdm.click();
            blueRentalPage.logOut.click();
            blueRentalPage.areYouSure.click();

        }



    }
}
