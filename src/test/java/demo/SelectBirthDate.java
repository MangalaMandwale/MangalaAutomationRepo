package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

//import java.time.Duration;

public class SelectBirthDate {
    @Test(expectedExceptions={InterruptedException.class})
    public void birthDate ()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/datepicker/");
        //driver.get("https://demo.automationtesting.in/Datepicker.html");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Thread.sleep(3000);
       /* driver.findElement(By.id("datepicker2")).click();

        WebElement dropDownMonth=driver.findElement(By.className("datepick-month-year"));
        Select selMonth=new Select(dropDownMonth);
        selMonth.selectByVisibleText("January");

        WebElement dropDownYear=driver.findElement(By.className("datepick-month-year"));
        Select selYear=new Select(dropDownYear);
        selYear.selectByVisibleText("1984");*/




        driver.findElement(By.xpath("//li[@id=\"Simple Date Picker\"]")).click();
       WebElement txtBox= driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
       txtBox.click();
        String selDate = "31";
        String selMonth = "January";
        String selYear = "1984";

        String birthMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        String birthYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        System.out.println(birthMonth);
        System.out.println(birthYear);

        if (birthMonth.equals(selMonth) && birthYear.equals(selYear)) {
            List<WebElement> allDates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//child::tbody/tr/td"));
            for (WebElement bDate : allDates) {
                if (bDate.getText().equals(selDate)) {

                    bDate.click();
                    break;
                }
            }

        }

        //Thread.sleep(3000);
        driver.close();
    }
    }


