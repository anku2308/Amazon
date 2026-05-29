package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablefunctions.SeleniumUtility;

public class AmazonCustomerServicePage {

    WebDriver driver;

    SeleniumUtility utility;

    public AmazonCustomerServicePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        utility = new SeleniumUtility(driver);
    }

    @FindBy(linkText = "Customer Service")
    WebElement customerService;

    public void goToCustomerServiceAndScrollDown() {

        utility.clickElement(customerService);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1500)");
    }
}