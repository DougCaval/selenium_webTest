package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--password-store=basic");
            options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "profile.password_manager_leak_detection", false
            ));
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quit(){

        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}