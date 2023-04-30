package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day24_Properties_Pages_PageKullanimi {
    @Test
    public void test1() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSource_Url"));
        /*
            Yukardaki adress için 20 adet test methodu oluşturursak sonrasında yukardaki url'de bir değişiklik
        olduğunda bütün test methodlarından tek tek url düzeltmek yerine bir kere .properties dosyamdan
        url'li düzeltirim ve bu bizim için daha hızlı daha düzenli ve daha kolay olur
         */


        //kullaniciAdi, kullaniciSifre, submitButton elementlerini bul

        OpenSourcePage openSourcePage = new OpenSourcePage(); //page kullanimi
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();

        //Login Testini basarili oldugunu test et
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());
        Driver.closeDriver();
    }



    }

