import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class SignInTest extends TestTemplate {
    @Test
    @DisplayName("Sign in with button Sign in account on main page")
    @Description("Check sign in with button Sign in account on main page")
    public void singInWithBtnOnHeadPageTest() {
        userSteps.create(user);

        Boolean actual = new MainPage(driver)
                .clickSignInCentralBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        Assert.assertTrue("В авторизованном профиле не отображается информационное сообщение!", actual);
    }

    @Test
    @DisplayName("Sign in profile with button person account")
    @Description("Check sign in profile with button person account")
    public void singInWithProfileBtnTest() {
        userSteps.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        Assert.assertTrue("В авторизованном профиле не отображается информационное сообщение!", actual);
    }

    @Test
    @DisplayName("Sign in with button Sign in in form registration")
    @Description("Check sign in with button Sign in in form registration")
    public void singInWithBtnOnRegistrationPageTest() {
        userSteps.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .clickRegistrationBtn()
                .clickSingInBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        Assert.assertTrue("В авторизованном профиле не отображается информационное сообщение!", actual);
    }

    @Test
    @DisplayName("Sign in with button Sign in form password recovery")
    @Description("Check sign in with button Sign in form password recovery")
    public void singInWithBtnOnForgottPasswordPageTest() {
        userSteps.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .clickForgottPasswordBtn()
                .clickSingInBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        Assert.assertTrue("В авторизованном профиле не отображается информационное сообщение!", actual);
    }
}
