package techproed.tests.day25_ExcelUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C06_DataProvider {
    @DataProvider
    public static Object[][] GoogleTest() {
        return new Object[][]{{"domates"},{"patates"}};
    }

    @Test(dataProvider = "GoogleTest")
    public void testName(String sebzeler) throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("google_Url"));
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(sebzeler, Keys.ENTER);

        try {
            Assert.assertTrue(googlePage.domatesVerify.isDisplayed());

        }catch (Exception e) {
            throw new IOException();
        }

        String Tarih= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "Ali/screenShot/scrrenShot"+Tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        Assert.assertTrue(googlePage.patatesVerify.isDisplayed());
        String tarih = new SimpleDateFormat("_hh/mm/ss_ddMMyyyy").format(new Date());
        String dosyAyolu ="Ali/screenShot/scrrenShot"+Tarih+".png";
        TakesScreenshot tss =(TakesScreenshot) Driver.getDriver();
        FileUtils.copyFile(googlePage.patatesVerify.getScreenshotAs(OutputType.FILE),new File(dosyAyolu));

    }
}
