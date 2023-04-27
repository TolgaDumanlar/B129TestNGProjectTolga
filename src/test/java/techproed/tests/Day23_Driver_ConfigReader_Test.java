package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day23_Driver_ConfigReader_Test {
    @Test
    public void testDriver() {
        //https://techproeducation.com/ sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));

        //title testi yapiniz
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Techpro"));


        //driveri kapatiniz
        Driver.closeDriver();
    }
}
