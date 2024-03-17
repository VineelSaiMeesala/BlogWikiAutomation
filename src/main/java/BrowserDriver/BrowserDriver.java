package BrowserDriver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
   public WebDriver Driverload(String Browser) {

       WebDriver driver = null;
       if (Browser == "chrome") {
           System.setProperty("WebDriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
           driver = new ChromeDriver();
       } else if (Browser == "edge") {
           driver = WebDriverManager.edgedriver().create();
       }
       return driver;
   }
}
