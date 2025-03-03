package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.ConfigReader;

public class NavigationSteps {

    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        driver.get(ConfigReader.getProperty("baseUrl"));
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed");
    }

    @When("the user navigates to {string} category")
    public void theUserNavigatesToCategory(String category) {
        homePage.clickCategory(category);
    }

    @Then("the user should see the {string} products")
    public void theUserShouldSeeTheProducts(String category) {
        Assert.assertTrue(homePage.isCategoryDisplayed(category), category + " products page is not displayed");
    }
}
