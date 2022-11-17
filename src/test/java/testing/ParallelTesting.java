package testing;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTesting {
    WebDriver driver;
    String name;
    @BeforeMethod
    public void setProperty()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Sagar1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void run_rediffmail()
    {
        driver.get("https://www.rediffmail.com");
        name=driver.getTitle();
    }

    @Test
    public void run_gmail()
    {
        driver.get("https://www.gmail.com");
        name=driver.getTitle();
    }

    @Test
    public void run_yahoo()
    {
        driver.get("https://www.google.com");
        name=driver.getTitle();
    }

    @AfterMethod
    public void closeWindow()
    {
        System.out.println("Closed "+name);
        driver.close();
    }
}
