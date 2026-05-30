package baseclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
    public static WebDriver driver;

    public void launchBrowser() {
        // Check if a system property or environment variable flags a Docker run
        String runMode = System.getProperty("execution_env", "local");

        if (runMode.equalsIgnoreCase("docker")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            
            try {
                // Connects to the 'selenium-chrome' service name defined in docker-compose
                driver = new RemoteWebDriver(new URL("http://selenium-chrome:4444/wd/hub"), options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            // Local desktop execution
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}