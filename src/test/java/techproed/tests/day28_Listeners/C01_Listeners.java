package techproed.tests.day28_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

//Classi listeners ile iliskilendirmek icin ya class basina @Listeners eklenir yada xml. dosyasina ekleme yapilir
@Listeners(techproed.utilities.Listeners.class)//Listeners classinin bulklundugu yolu belirtiyoruz
public class C01_Listeners {
    @Test
    public void successTest(){
        System.out.println("PASS");
        assertTrue(true);
    }


    @Test
    public void failTest(){
        System.out.println("FAIL");
        assertTrue(false);
    }


    @Test
    public void skipTest(){
        System.out.println("SKIP");
        throw new SkipException("Atlandı!!!");
    }

    @Test
    public void failTestTechpro(){
        System.out.println("TechPro Fail Test");
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
        Driver.getDriver().findElement(By.xpath("//OlmayanXpath"));

    }




}
