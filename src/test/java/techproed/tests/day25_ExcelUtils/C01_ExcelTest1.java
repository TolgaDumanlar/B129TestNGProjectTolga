package techproed.tests.day25_ExcelUtils;

import org.testng.annotations.Test;
import techproed.utilities.ExcelUtils;

import java.io.FileNotFoundException;

public class C01_ExcelTest1 {
    @Test
    public void testTest1()  {
        String path ="C:\\Users\\ASUS\\IdeaProjects\\B129TestNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sayfa);

        System.out.println(excelUtils.getCellData(1, 0));
        String email = excelUtils.getCellData(1,0);
        String password = excelUtils.getCellData(1,1);
        System.out.println(email+"||"+password);


    }
}
