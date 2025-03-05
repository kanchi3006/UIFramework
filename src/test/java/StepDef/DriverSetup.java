package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverSetup {

    private static WebDriver driver;


     public DriverSetup() {
         System.out.println("Inside DriverSetup");
            WebDriverManager.edgedriver().setup();
            EdgeOptions edge = new EdgeOptions();
            ChromeOptions chrome = new ChromeOptions();
         DesiredCapabilities cap = new DesiredCapabilities();
         //   chrome.addArguments("--headless");
         //   driver = new ChromeDriver(chrome);
          //  driver = new ChromeDriver();
         driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

    public static WebDriver getLocal()
    {
        return driver;
    }


}