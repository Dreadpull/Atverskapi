package delfi_atverskapi;

import delfi_atverskapi.BaseFunc;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterPage {
    private BaseFunc baseFunc;

    public RegisterPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By USERNAME_FIELD = By.xpath(".//input[@id='name']");
    private final String NAME = "Tester";
    private final By EMAIL_LOCATOR = By.xpath(".//input[@id='email']");
    private final By PASSWORD_LOCATOR = By.xpath(".//input[@id='password']");
    private final By PASSWORD_CONFIRM_LOCATOR = By.xpath(".//input[@id='password-confirm']");
    private final By SUBMIT_BTN = By.xpath(".//button[contains(@class,'btn btn-blue')]");

    private final String PASSWORD = "123456";


    public void fillUsernameField() {
        baseFunc.fillField(USERNAME_FIELD, NAME);
    }

    public void fillEmailField(String EMAIL_ADDRESS) {
        baseFunc.fillField(EMAIL_LOCATOR, EMAIL_ADDRESS);
    }

    public void fillPasswordField(String PASSWORD) {
        baseFunc.fillField(PASSWORD_LOCATOR, PASSWORD);
    }

    public void fillPasswordConfirmField(String PASSWORD) {
        baseFunc.fillField(PASSWORD_CONFIRM_LOCATOR, PASSWORD);
    }

    public void clickOnSubmitBtn() {
        baseFunc.getElement(SUBMIT_BTN).click();
    }
}
