import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class SwitchFromAccountToConstructor extends TestTemplate {
    @Test
    @DisplayName("Go to profile without authorization")
    @Description("Check Go to profile without authorization")
    public void goToProfilePageWithoutAuthTest() {
        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .isSignInBtnDisplayed();
        Assert.assertTrue("Форма входа не открывается у не авторизованных пользователей!", actual);
    }

    @Test
    @DisplayName("Go to profile with authorization")
    @Description("Check go to profile with authorization")
    public void goToProfilePageWithAuthTest() {
        userSteps.create(user);
        Boolean actual = new MainPage(driver)
                .clickSignInCentralBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        Assert.assertTrue("Профиль не открывается у авторизованных пользователей!", actual);
    }

    @Test
    @DisplayName("Go to from profile without authorization in the constructor")
    @Description("Check go to profile without authorization in the constructor")
    public void goFromProfilePageWithoutAuthTest() {
        Boolean actual = new MainPage(driver)
                .clickSignInCentralBtn()
                .clickConstructorBtn()
                .isBunsIsDisplayed();
        Assert.assertTrue("Раздел Конструктор не открывается у не авторизованных пользователей!", actual);
    }

    @Test
    @DisplayName("Go to from profile with authorization in the constructor")
    @Description("Check go to profile with authorization in the constructor")
    public void goFromProfilePageWithAuthTest() {
        userSteps.create(user);

        Boolean actual = new MainPage(driver)
                .clickSignInCentralBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .clickConstructorBtn()
                .isBunsIsDisplayed();
        Assert.assertTrue("Раздел Конструктор не открывается у авторизованных пользователей!", actual);
    }

    @Test
    @DisplayName("Go to from profile with authorization with click logo")
    @Description("Check go to profile with authorization with click logo")
    public void goFromProfilePageWithAuthWhenClickLogoTest() {
        userSteps.create(user);
        Boolean actual = new MainPage(driver)
                .clickSignInCentralBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .clickLogoBtn()
                .isBunsIsDisplayed();
        Assert.assertTrue("Главная станица, не открывается, когда авторизованный пользователь кликнул на логотип", actual);

    }
}
