package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day23_SoftAssertion {

    @Test
    public void testSoftAssert() {
        //softassert yapabilmek icin 3 adimi izliyoruz
        //1inci Adim : Softassert objesi olustur
        SoftAssert softAssert=new SoftAssert();

        //2nci Adim : Assertion yapin
        //1.assertion
        softAssert.assertEquals(1,2);

        //2.assertion
        softAssert.assertTrue("Selenium".contains("e"));

        //3uncu Adim : AssertAll() methodunu calistirin
        softAssert.assertAll();
        System.out.println("hello");//fail oldugundan calima durdu cunku ustte ki koddan dolayi, bu kodu yazdirmaz

    }
}
