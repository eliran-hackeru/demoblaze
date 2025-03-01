package stepDefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import base.BaseTest;
import utils.XMLTestDataUtil;
import org.testng.Assert;

import java.util.Objects;

public class LoginSteps extends BaseTest {
    HomePage homePage;

    @Given("the user is on the home page and clicked the Login button")
    public void theUserIsOnTheHomePage() {
        driver.get("https://www.demoblaze.com/");
        homePage = new HomePage(driver);
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

        //WaitUtils.waitForElementToContainText(driver, homePage.getNameOfUserElement(), username, 10);

        Assert.assertTrue(homePage.getNameOfUser().contains(Objects.requireNonNull(username)));
    }
}
