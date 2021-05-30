import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

//public class GridTest {
//
//    @Test
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities cap=new DesiredCapabilities();
//        cap.setBrowserName( "firefox" );
//        cap.setPlatform( Platform.WINDOWS );
//
////        DesiredCapabilities cap=new DesiredCapabilities();
////        cap.setBrowserName( "chrome" );
////        cap.setPlatform( Platform.WINDOWS );
//
//        ChromeOptions options=new ChromeOptions();
//        options.merge( cap );
//
//        String hubURL="http://192.168.0.104:4444/wd/hub";
//        WebDriver driver=new RemoteWebDriver( new URL( hubURL ),options );
//        driver.manage().window().maximize();
//        driver.get( "https://www.miniaturemarket.com/" );
//        System.out.println(driver.getTitle());
//        System.out.println(">> "+cap.getBrowserName());
//        driver.quit();
//
//
//    }
//
//}
