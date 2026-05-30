package reusablefunctions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class SeleniumUtility {

    WebDriver driver;

    public SeleniumUtility(WebDriver driver) {

        this.driver = driver;
    }

    public void clickElement(WebElement element) {

        element.click();
    }

    public void enterValue(WebElement element, String value) {

        element.sendKeys(value);
    }

    public void scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,3000)");
    }

    public void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        
        // Create the directory object
        File folder = new File("./Screenshots");
        if (!folder.exists()) {
            folder.mkdirs(); // This creates the Screenshots folder automatically in Linux/Docker
        }
        
        File dest = new File(folder, fileName + "amazon.png");
        FileHandler.copy(src, dest);
    }
    }

