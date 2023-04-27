package techproed.tests;

import org.testng.annotations.Test;

public class Day23_DepensOnMethods {
     /*
    Test NG'de @Test metotları birbirinden bağımsız çalışır.
    Methodları bağımlı çalıştırmak istiyorsak "dependsOnMethods" parametresi kullanılır.
    Aşağıda seachTest() methodu homePageTest() methoduna bağlıdır.
    Eğer homePageTest() çalışırsa seachTest() de çalışır.
    Eğer homePageTest() fail olursa seachTest() çalışmaz, "ignore" edilir.
     */

    @Test
    public void testHomePage() {
        System.out.println("Ana sayfaya gidildi..");
    }
    @Test(dependsOnMethods = "testHomePage")
    public void testSearch() {
        System.out.println("Arama yapildi..");
    }

    @Test(dependsOnMethods = "testHomePage")
    public void testSignIn() {
        System.out.println("Giris yapildi");
    }
}
