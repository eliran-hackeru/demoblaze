package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class HomePage {
    private WebDriver driver;

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
}
