package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusablefunctions.SeleniumUtility;

public class AmazonHomePage {

    WebDriver driver;

    SeleniumUtility utility;

    public AmazonHomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

        utility = new SeleniumUtility(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    @FindBy(linkText = "Customer Service")
    WebElement customerService;

    public void searchProduct(String product) {

    	// Example using Explicit Wait in your Page Object
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
    	searchBox.sendKeys("headphones");
        utility.enterValue(searchBox, product);

        utility.clickElement(searchButton);
    }

    public void clickCustomerService() {

        try {

            Thread.sleep(3000);

        } catch (Exception e) {

            e.printStackTrace();
        }

        utility.clickElement(customerService);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }
}