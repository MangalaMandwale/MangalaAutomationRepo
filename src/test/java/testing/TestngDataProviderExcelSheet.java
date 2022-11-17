package testing;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class TestngDataProviderExcelSheet {
    WebDriver driver;

    @DataProvider(name="test-data")
    public Object[][] excelDataProvider(){
        Object[][] arrObj=getExcelData("D:\\Testing PPT\\TestData.xlsx","Data");
        return arrObj;
    }
    public String[][] getExcelData(String fileName,String sheetName){
        String[][] data=null;
        try{
            FileInputStream fileInputStream=new FileInputStream(fileName);
            XSSFWorkbook wb=new XSSFWorkbook(fileInputStream);
            XSSFSheet sh=wb.getSheet(sheetName);
            XSSFRow row=sh.getRow(0);
            int noOfRows=sh.getPhysicalNumberOfRows();
            int noOfColumns=row.getLastCellNum();

            Cell cell;

            for(int i=1;i<noOfRows;i++) {
                for (int j = 0; j < noOfColumns; j++) {
                    row = sh.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();


                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return data;
    }

    @Parameters({"browserName"})
    @BeforeMethod
    public void testScript(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar1\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Sagar1\\Downloads\\chromedriver_win32\\edgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Please select correct browser");
        }
    }


    @Test(dataProvider = "test-data")
    public void run1(String s1,String s2) {
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(s1 + " " + s2);
        element.sendKeys(Keys.ENTER);
    }

    @Test(dataProvider = "test-data")
    public void run2(String s1,String s2) {
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(s1 + " " + s2);
        element.sendKeys(Keys.ENTER);
    }

    @AfterMethod
    public void afterMethodExample(){
        driver.close();

    }

}
