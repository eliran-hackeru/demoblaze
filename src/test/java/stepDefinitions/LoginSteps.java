package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import base.BaseTest;
import utils.XMLTestDataUtil;
import org.testng.Assert;

public class LoginSteps extends BaseTest {
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get("https://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        String username = XMLTestDataUtil.getValue("validUser", "username");
        String password = XMLTestDataUtil.getValue("validUser", "password");
        loginPage.login(username, password);
    }

    @Then("the user should be redirected to the dashboard")
    public void theUserShouldBeRedirectedToTheDashboard() {
        // Add assertion for dashboard verification
        Assert.assertEquals(driver.getCurrentUrl(), "https://example.com/dashboard");
    }
}
