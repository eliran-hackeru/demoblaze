package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.AlertUtil.acceptAlert;
import static utils.AlertUtil.getAlertText;
import static utils.WaitUtils.waitForElementToBeClickable;

public class ProductPage extends HomePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.btn.btn-success.btn-lg[href='#']")
    private WebElement addToCartButton;

    public void addProductToCart() {
        waitForElementToBeClickable(driver, addToCartButton, 10);

        addToCartButton.click();

        System.out.println(getAlertText(driver));

        acceptAlert(driver);
    }
}