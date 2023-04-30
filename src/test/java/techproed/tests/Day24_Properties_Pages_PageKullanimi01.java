package techproed.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterTechproPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day24_Properties_Pages_PageKullanimi01 {
    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Page object Model kullanarak sayfaya giriş yapildigini test edin
    //Sayfadan cikis yap ve cikis yapildigini test et


    @Test
    public void test1() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterTechproPage testCenterTechproPage = new TestCenterTechproPage();
        testCenterTechproPage.userName.sendKeys(ConfigReader.getProperty("kullanicAdi"), Keys.TAB,
                ConfigReader.getProperty("kullaniciPassword"),Keys.ENTER);
        Assert.assertTrue(testCenterTechproPage.text.isDisplayed());
        //Sayfadan cikis yap ve cikis yapildigini test et
        testCenterTechproPage.logout.click();
        Assert.assertTrue(testCenterTechproPage.giris.isDisplayed());
    }
}
