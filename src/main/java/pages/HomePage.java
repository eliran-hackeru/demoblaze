package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUtil;
import utils.WaitUtils;

import java.time.Duration;
import java.util.List;

public class HomePage {
    protected WebDriver driver;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(css = "button[onclick='logIn()']")
    private WebElement enterButton;

    @FindBy(id = "nameofuser")
    private WebElement nameOfUser;

    @FindBy(id = "logInModalLabel")
    private WebElement loginForm;

    @FindBy(css = "h4.card-title a.hrefch")
    private List<WebElement> products;

    @FindBy(id = "cartur")
    private WebElement cartButton;

    @FindBy(id = "tbodyid")
    private WebElement tableBody;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        WaitUtils.waitForElementToBeClickable(driver, loginButton, 10);
        loginButton.click();
    }

    public void login(String username, String password) {
        WaitUtils.waitForElementToBeVisible(driver, loginForm, 10);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        enterButton.click();
    }

    public String getNameOfUser() {
        WaitUtils.waitForElementToBeVisible(driver, nameOfUser, 10);
        return nameOfUser.getText();
    }

    public void clickOnRandomProduct() {
        WaitUtils.waitForElementToBeVisible(driver, tableBody, 10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(products));

        products.getLast().click();
    }

    public void goToCart() {
        cartButton.click();
    }
}
