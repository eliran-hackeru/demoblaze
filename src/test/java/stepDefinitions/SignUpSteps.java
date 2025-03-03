package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.ConfigReader;
import utils.WaitUtils;

import static org.testng.Assert.assertTrue;

public class SignUpSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @Given("the user is on the home page and clicked the Sign Up button")
    public void theUserIsOnTheHomePageAndClickedTheSignUpButton() {
        driver.get(ConfigReader.getProperty("baseUrl"));
        assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed");
        homePage.clickSignUpButton();
    }

    @When("the user enters new valid credentials")
    public void theUserEntersNewValidCredentials() {
        homePage.enterSignUpUsername("TestUser" + System.currentTimeMillis()); // Unique username
        homePage.enterSignUpPassword("TestPassword123");
        homePage.clickSignUpConfirmButton();
    }

    @Then("the user would get a sign up successful message")
    public void theUserWouldGetASignUpSuccessfulMessage() {
        String alertText = WaitUtils.waitForAlertAndGetText(driver);
        assertTrue(alertText.contains("Sign up successful"), "Expected 'Sign up successful' message, but got: " + alertText);
        driver.switchTo().alert().accept(); // Close the alert
    }
}
