package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.WaitUtils.*;

public class CartPage extends HomePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn.btn-success[data-target='#orderModal']")
    private WebElement placeOrderButton;

    @FindBy(className = "success")
    private WebElement item;

    @FindBy(id = "totalm")
    private WebElement totalm;

    @FindBy(id = "name")
    private WebElement fullName;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "card")
    private WebElement creditCard;

    @FindBy(id = "month")
    private WebElement cardMonth;

    @FindBy(id = "year")
    private WebElement cardYear;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    private WebElement purchase;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible")
    private WebElement alertModal;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible h2")
    private WebElement alertMessage;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private List<WebElement> cartItems; // Column #2 contains product names

    @FindBy(xpath = "//tbody/tr/td[4]/a")
    private List<WebElement> deleteButtons; // "Delete" buttons for each product

    public void placeAnOrder() {
        waitForElementToBeVisible(driver, item, 10);
        waitForElementToBeClickable(driver, placeOrderButton, 10);

        placeOrderButton.click();

        waitForElementToBeVisible(driver, totalm, 10);

        fullName.sendKeys("Moshe Cohen");
        country.sendKeys("Israel");
        city.sendKeys("Ashdod");
        creditCard.sendKeys("4580030287114352");
        cardMonth.sendKeys("06");
        cardYear.sendKeys("2026");

        purchase.click();
    }

    public void verifiedPurchase() {
        waitForElementToBeVisible(driver, alertModal, 10);
    }

    public String getSuccessMessage() {
        return alertMessage.getText();
    }

    public boolean isProductInCart(String productName) {
        //waitForElementToBeVisible(driver, cartItems.getFirst(), 10);
        waitForAllElementsToBeVisible(driver, cartItems, 10);
        for (WebElement item : cartItems) {
            if (item.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeProductFromCart(String productName) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getText().equalsIgnoreCase(productName)) {
                deleteButtons.get(i).click(); // Click the corresponding delete button

                WebElement item = cartItems.get(i); // Hold the item for the wait
                waitForElementToBeStale(driver, item, 10); // Wait for item to disappear
                return; // Exit after deleting the product
            }
        }
        throw new NoSuchElementException("Product '" + productName + "' not found in the cart.");
    }

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }
}
