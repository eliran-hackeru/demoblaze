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

public class CartSteps {
    WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    String productName = "";

    @Given("the user has entered the home page")
    public void theUserIsOnTheHomePage() {
        driver.get(ConfigReader.getProperty("baseUrl"));
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed");
    }

    @And("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        homePage.clickOnRandomProduct();

        productName = productPage.getProductName();

        productPage.addProductToCart();
    }

    @When("the user goes to the cart")
    public void theUserGoesToTheCart() {
        homePage.goToCart();
    }

    @And("the cart contains the product")
    public void theCartContainsTheProduct() {
        Assert.assertTrue(cartPage.isProductInCart(productName), "Product was not found in the cart");
    }

    @And("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        cartPage.removeProductFromCart(productName);
    }

    @Then("the cart would be empty")
    public void theCartWouldBeEmpty() {
        Assert.assertTrue(cartPage.isCartEmpty(), "The cart is not empty after removing all items.");
    }
}
