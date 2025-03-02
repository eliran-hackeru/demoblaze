package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.ConfigReader;
import utils.XMLTestDataUtil;

import java.util.Objects;

public class CheckoutSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);


    @Given("the user has items in their cart")
    public void theUserHasItemsInTheirCart() {
        driver.get(ConfigReader.getProperty("baseUrl"));

        homePage.clickOnRandomProduct();

        productPage.addProductToCart();
    }

    @When("they go to checkout and they enter valid payment and shipping details")
    public void theyGoToCheckout() {
        homePage.goToCart();

        cartPage.placeAnOrder();
    }

    @Then("the order should be successfully placed")
    public void theOrderShouldBeSuccessfullyPlaced() {
        cartPage.verifiedPurchase();

        String message = cartPage.getSuccessMessage();
        Assert.assertEquals(message, "Thank you for your purchase!");
    }
}
