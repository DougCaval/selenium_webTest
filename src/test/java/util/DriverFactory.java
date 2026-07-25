package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-password-manager-onboarding");
            options.addArguments("--disable-features=PasswordManagerOnboarding");
            options.addArguments("--disable-save-password-bubble");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.password_manager", 2);
            options.setExperimentalOption("prefs", prefs);

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