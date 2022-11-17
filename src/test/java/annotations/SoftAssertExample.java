package annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
    SoftAssert softAssert=new SoftAssert();

    WebDriver driver;

    @BeforeMethod
    public void beforeMethodExample(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sagar1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        System.out.println("Before Method");
        driver=new ChromeDriver();
    }
    @Test
    public void run()
    {
        driver.get("https://www.google.com");
        String title=driver.getTitle();
        System.out.println(title);
        softAssert.assertEquals(title,"Google","title should be equal");
        softAssert.assertNotEquals(title,"google","Title is not equal");
        softAssert.assertEquals(title,"google","Title should be equal");
        softAssert.assertAll();
    }
    @AfterMethod
    public void afterMethodExample(){
        driver.close();
    }

}
