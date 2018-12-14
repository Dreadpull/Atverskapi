package delfi_atverskapi;

import org.openqa.selenium.By;

import java.util.Random;

public class ResetPasswordPage {
    private BaseFunc baseFunc;

    private final By EMAIL_LOCATOR = By.xpath(".//input[@id='email']");
    private final By LOGIN = By.xpath(".//a[contains(@data-target,'#login-modal')]");

    private final By SUBMIT_BTN = By.xpath(".//button[@type='submit' and @class='btn btn-primary']");

    public ResetPasswordPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillEmailField(String EMAIL_ADDRESS) {
        baseFunc.fillField(EMAIL_LOCATOR, EMAIL_ADDRESS);
    }

    public void clickOnSubmitBtn() {
        baseFunc.getElement(SUBMIT_BTN).click();
    }
    public void clickLoginBtn() {
        baseFunc.getElement(LOGIN).click();
    }
}
