package utils;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class Driver {
    public Driver() {

    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--disable-geolocation");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    edgeOptions.addArguments("--inprivate");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "firefox-geodisabled":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions geoDisabled = new FirefoxOptions()
                            .addPreference("browser.privatebrowsing.autostart", true)
                            .addPreference("dom.webnotifications.enabled", false)
                            .addPreference("geo.enabled", false)
                            .addPreference("geo.provider.use_corelocation", false)
                            .addPreference("geo.prompt.testing", false)
                            .addPreference("geo.prompt.testing.allow", false);
                    geoDisabled.addArguments("-private");
                    driver = new FirefoxDriver(geoDisabled);
                    break;

                default:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
