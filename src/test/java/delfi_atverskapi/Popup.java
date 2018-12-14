package delfi_atverskapi;

import org.openqa.selenium.By;

public class Popup {
    private BaseFunc baseFunc;

    private final By FORGOT_PASSWORD = By.xpath(".//a[contains(@href,'/password/reset/')]");
    private final By EMAIL_LOCATOR = By.xpath(".//input[@id='email' and @type='text']");
    private final By PASSWORD_LOCATOR= By.xpath(".//input[@type='password' and @name='password']");

    public Popup(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickOnForgotPassword() {
        baseFunc.getElement(FORGOT_PASSWORD).click();
    }

    public void fillEmailField(String EMAIL_ADDRESS) {
        baseFunc.fillField(EMAIL_LOCATOR, EMAIL_ADDRESS);
    }

    public void fillPasswordField(String PASSWORD) {
        baseFunc.fillField(PASSWORD_LOCATOR, PASSWORD);
    }
}
