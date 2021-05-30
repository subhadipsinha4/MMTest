package com.market.qa.baseTest;

import com.market.qa.util.TestUtil;
import com.market.qa.util.WebEventListener;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public static DesiredCapabilities cap;
    public static FirefoxOptions options;

    public BaseTest() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\MMTest\\src\\main\\java\\com\\market\\qa\\config\\config.properties");
        prop.load(fis);
       // cap=new DesiredCapabilities();
        //options=new FirefoxOptions();

    }

    public static void initilize() throws IOException {
        String browserName=prop.getProperty("browser");

        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\MMTest\\Driver\\chromedriver.exe");
            driver= new ChromeDriver();

        }
//        if(browserName.equals("firefox"))
//        {
//            System.setProperty("webdriver.gecko.driver","C:\\MM Test\\target\\driver\\geckodriver.exe");
//            driver= new FirefoxDriver();
//
//        }
//        cap.setBrowserName( "firefox" );
//        cap.setPlatform( Platform.WINDOWS );
//        options.merge( cap );
//        String hubUrl="http://192.168.0.104:4444/wd/hub";
//        driver= new RemoteWebDriver( new URL(hubUrl),options );

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
