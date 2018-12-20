package delfi_atverskapi;

import org.openqa.selenium.By;

public class MenuHelper {
    private final By OPEN_PROFILE_MENU = By.xpath(".//img[@class='navbar-profile-img img img-circle']");
    private final By LOGOUT = By.xpath(".//a[contains(@onclick,'logout-form')]");
    private final By LOGIN = By.xpath(".//a[contains(@data-target,'#login-modal')]");
    private final By REG_BTN = By.xpath(".//a[@href = 'https://atverskapi.delfi.lv/lv/register']");
    private BaseFunc baseFunc;

    public MenuHelper(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickOnRegBtn() {
        baseFunc.getElement(REG_BTN).click();
    }

    public void openProfileDropDown() {
        baseFunc.getElement(OPEN_PROFILE_MENU).click();
    }

    public void clickLogoutInDropdown() {
        baseFunc.getElement(LOGOUT).click();
    }

    public void clickLoginBtn() {
        baseFunc.getElement(LOGIN).click();
    }


}
