package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.WaitUtils.waitForElementToBeClickable;
import static utils.WaitUtils.waitForElementToBeVisible;

public class CartPage extends HomePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn.btn-success[data-target='#orderModal']")
    private WebElement placeOrderButton;

    @FindBy(className = "success")
    private WebElement item;

    @FindBy(id ="totalm")
    private WebElement totalm;

    @FindBy(id = "name")
    private WebElement fullName;

    @FindBy(id ="country")
    private WebElement country;

    @FindBy(id ="city")
    private WebElement city;

    @FindBy(id ="card")
    private WebElement creditCard;

    @FindBy(id ="month")
    private WebElement cardMonth;

    @FindBy(id ="year")
    private WebElement cardYear;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    private WebElement purchase;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible")
    private WebElement alertModal;

    @FindBy(css = "div.sweet-alert.showSweetAlert.visible h2")
    private WebElement alertMessage;


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
}
