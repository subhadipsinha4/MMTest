import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGTest2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\unbxd\\IdeaProjects\\com.website.test\\target\\driver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.miniaturemarket.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test(priority=1)
    public void searchTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='search']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("card"+ Keys.ENTER);
    }

    @Test(priority=2)
    public void verifySearhResult()
    {
        driver.findElement(By.xpath("//input[@id='search']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("card"+ Keys.ENTER);
        if(driver.getCurrentUrl().contains("searchresults"))
            System.out.println("Pass");
        else
            System.out.println("Fail");
    }

    @AfterMethod
    public void closeUp()
    {
        driver.quit();
    }



}
