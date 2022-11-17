package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Annotations {
    WebDriver driver;
    @BeforeClass
    public void beforeClassExample(){
        System.out.println("Before class Example");
    }

    @BeforeMethod
    public void beforMethodExample()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void run1()
    {
        driver.get("https://www.google.com");
    }
    @Test
    public void run2()
    {
        driver.get("https://www.facebook.com");
    }
    @AfterMethod
    public void afterMethodExample()
    {
        driver.close();
    }

    @AfterClass
    public void afterClassExample(){
        System.out.println("After class example");
    }
}
