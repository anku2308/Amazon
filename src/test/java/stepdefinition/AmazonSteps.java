package stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import Pages.AmazonCustomerServicePage;
import Pages.AmazonHomePage;
import baseclass.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import reusablefunctions.SeleniumUtility;

public class AmazonSteps extends BaseTest {

    AmazonHomePage home;

    AmazonCustomerServicePage customer;

    SeleniumUtility utility;

    @Given("User opens browser and launches Amazon website")
    public void user_opens_browser_and_launches_amazon_website() {

        launchBrowser();

        home = new AmazonHomePage(driver);

        utility = new SeleniumUtility(driver);
    }

    @Then("Verify page title contains Amazon")
    public void verify_page_title_contains_amazon() throws InterruptedException {

        Thread.sleep(5000);

        String title = driver.getTitle();

        System.out.println("Page Title is: " + title);

        Assert.assertTrue(title.toLowerCase().contains("amazon"));
    }

    @When("User searches for {string}")
    public void user_searches_for(String product) {

        home.searchProduct(product);
    }

    @Then("User scrolls down the page")
    public void user_scrolls_down_the_page() {

        utility.scrollDown();
    }

    @When("User clicks on customer service")
    public void user_clicks_on_customer_service() {

        customer = new AmazonCustomerServicePage(driver);

        customer.goToCustomerServiceAndScrollDown();
    }

    @And("User takes screenshot")
    public void user_takes_screenshot() throws IOException {

        utility.takeScreenshot("AmazonCustomerService");
    }

    @Then("Close browser")
    public void close_browser() {

        closeBrowser();
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}