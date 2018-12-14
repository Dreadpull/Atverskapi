package delfi_atverskapi.tests;

import delfi_atverskapi.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class AtverskapiTest {


    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage = new HomePage(baseFunc);
    private Popup popup = new Popup(baseFunc);
    private ResetPasswordPage resetPasswordPage = new ResetPasswordPage(baseFunc);
    private RegisterPage registerPage = new RegisterPage(baseFunc);

    private final String HOME_PAGE = "atverskapi.delfi.lv";
    //private final String EMAIL_PAGE = "www.gmail.com";

    // private final By REG_BTN = By.xpath(".//a[@href = 'http://atverskapi.delfi.lv/lv/register']");
    //private final By USERNAME_FIELD = By.xpath(".//input[@id='name']");
    //private final By EMAIL_LOCATOR = By.xpath(".//input[@id='email']");
    //private final By PASSWORD_LOCATOR = By.xpath(".//input[@id='password']");
    //private final By PASSWORD_CONFIRM_LOCATOR = By.xpath(".//input[@id='password-confirm']");
    //private final By SUBMIT_BTN = By.xpath(".//button[@type='submit']");
    //private final By OPEN_PROFILE_MENU = By.xpath(".//img[@class='navbar-profile-img img img-circle']");
    //private final By LOGOUT = By.xpath(".//a[contains(@onclick,'logout-form')]");
    //private final By LOGIN = By.xpath(".//button[contains(@class,'btn btn-blue navbar')]");
    //private final By FORGOT_PASSWORD = By.xpath(".//a[contains(@href,'/password/reset/')]");
    Random random = new Random();
    int randomInt = random.nextInt(10000) + 1;
    private final String EMAIL_ADDRESS = "andris.test.agda+" + randomInt + "@gmail.com";
    private final String PASSWORD = "123456";


    @Test
    public void registrationTest() {


        baseFunc.goToURL(HOME_PAGE);
        homePage.clickOnRegBtn();
        registerPage.fillUsernameField();
        registerPage.fillEmailField(EMAIL_ADDRESS);
        registerPage.fillPasswordField(PASSWORD);
        registerPage.fillPasswordConfirmField(PASSWORD);
        registerPage.clickOnSubmitBtn();
        homePage.openProfileDropDown();
        homePage.clickLogoutInDropdown();
        homePage.clickLoginBtn();
        popup.clickOnForgotPassword();
        resetPasswordPage.fillEmailField(EMAIL_ADDRESS);
        resetPasswordPage.clickOnSubmitBtn();
        //resetPasswordPage.clickLoginBtn();
        //popup.fillEmailField(EMAIL_ADDRESS);
        //popup.fillPasswordField(PASSWORD);

    }

}
