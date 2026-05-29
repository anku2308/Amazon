package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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