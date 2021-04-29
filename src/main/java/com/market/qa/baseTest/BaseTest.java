package com.market.qa.baseTest;

import com.market.qa.util.TestUtil;
import com.market.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;

    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public BaseTest() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\unbxd\\IdeaProjects\\com.website.test\\src\\main\\java\\com\\market\\qa\\config\\config.properties");
        prop.load(fis);
    }

    public static void initilize() throws IOException {
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\unbxd\\IdeaProjects\\com.website.test\\target\\driver\\chromedriver.exe");
            driver= new ChromeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
    }

}
