package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
    @DataProvider
    public Object[][] sehirVerileri(){
        Object[][] array = {{"Istanbul","Marmara","34"},
                            {"Diyarbakir","Guneydogu","21"},
                            {"Ankara","Icanadolu","06"}};
        return array;
    }
    @DataProvider
    public Object[][] kullaniciBilgileri(){
        Object[][] array = {{"Ali","Ali.123"},
                {"Ayse","Ayse.123"},
                {"Fatma","Ftm_987",}};
        return array;
    }
    @DataProvider()
    public Object[][] customerData(){

        //ExcelUtils Objesi olusturarak
        String path = "C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sayfa);
        return  excelUtils.getDataArrayWithoutFirstRow();
    }
}
