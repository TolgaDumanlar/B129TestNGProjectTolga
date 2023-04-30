package techproed.tests;

import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day24_Properties_Pages_ClassWork {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));
        Driver.closeDriver();
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));
    }
}
