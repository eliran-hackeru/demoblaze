package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.AlertUtil.acceptAlert;
import static utils.AlertUtil.getAlertText;
import static utils.WaitUtils.waitForElementToBeClickable;
import static utils.WaitUtils.waitForElementToBeVisible;

public class ProductPage extends HomePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.btn.btn-success.btn-lg[href='#']")
    private WebElement addToCartButton;

    @FindBy(className = "name")
    private WebElement productName;

    public void addProductToCart() {
        waitForElementToBeClickable(driver, addToCartButton, 10);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addToCartButton);
    }

    public String getProductName() {
        waitForElementToBeVisible(driver, productName, 10);
        return productName.getText();
    }
}