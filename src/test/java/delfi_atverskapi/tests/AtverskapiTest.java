package delfi_atverskapi.tests;


import delfi_atverskapi.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class AtverskapiTest {


    private BaseFunc baseFunc = new BaseFunc();




    private JavaMail javaMail = new JavaMail(baseFunc);

    Random random = new Random();
    int randomInt = random.nextInt(10000) + 1;

    private final String HOME_PAGE = "atverskapi.delfi.lv";
    private final String EMAIL_ADDRESS = "andris.test.agda+" + randomInt + "@gmail.com";
    private final String PASSWORD = "123456";
    private final String NEW_PASSWORD = "654321";


    @Test
    public void registrationTest() throws InterruptedException {


        baseFunc.goToURL(HOME_PAGE);



        MenuHelper menuHelper = new MenuHelper(baseFunc);
        menuHelper.clickOnRegBtn();

        RegisterPage registerPage = new RegisterPage(baseFunc);
        registerPage.fillUsernameField();
        registerPage.fillEmailField(EMAIL_ADDRESS);
        registerPage.fillPasswordField(PASSWORD);
        registerPage.fillPasswordConfirmField(PASSWORD);
        baseFunc.timeForUserToCompleteCaptcha();
        registerPage.clickOnSubmitBtn();

        menuHelper  = new MenuHelper(baseFunc);
        menuHelper.openProfileDropDown();
        menuHelper.clickLogoutInDropdown();
        menuHelper.clickLoginBtn();

        Popup popup = new Popup(baseFunc);
        popup.clickOnForgotPassword();

        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(baseFunc);
        resetPasswordPage.fillEmailField(EMAIL_ADDRESS);
        resetPasswordPage.clickOnSubmitBtn();
        String resetPasswordLink = javaMail.checkInboxForResetLink();
        baseFunc.goToURL(resetPasswordLink);
        resetPasswordPage.fillEmailField(EMAIL_ADDRESS);
        resetPasswordPage.fillPasswordField(NEW_PASSWORD);
        resetPasswordPage.fillPasswordConfirmField(NEW_PASSWORD);
        resetPasswordPage.clickOnSubmitBtn();



    }


}
