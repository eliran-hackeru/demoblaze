package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.ConfigReader;
import utils.XMLTestDataUtil;
import org.testng.Assert;

import java.util.Objects;

public class LoginSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @Given("the user is on the home page and clicked the Login button")
    public void theUserIsOnTheHomePage() {
        driver.get(ConfigReader.getProperty("baseUrl"));
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed");

        homePage.clickLogin();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        String username = XMLTestDataUtil.getValue("validUser", "username");
        String password = XMLTestDataUtil.getValue("validUser", "password");
        homePage.login(username, password);
    }

    @Then("the user name should be appeared on the page header")
    public void theUserNameShouldBeAppeared() {
        String username = XMLTestDataUtil.getValue("validUser", "username");

        Assert.assertTrue(homePage.getNameOfUser().contains(Objects.requireNonNull(username)));
    }
}