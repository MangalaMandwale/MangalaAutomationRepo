package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import java.util.List;

public class DatePickerExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar1\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/datepicker/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Thread.sleep(3000);
        driver.findElement(By.id("datepicker")).click();

        //driver.findElement(By.xpath("//li[@id=\"Simple Date Picker\"]")).click();
        // WebElement txtBox= driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
        //txtBox.click();
        String selDate = "31";
        String selMonth = "January";
        String selYear = "2022";

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

       // Thread.sleep(3000);
        driver.close();
    }
    }


