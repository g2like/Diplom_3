import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class RegistrationTest extends TestTemplate {
    @Test
    @DisplayName("Registration user with valid data")
    @Description("Check registration user with valid data")
    public void registerNewUserTest() {

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .clickRegistrationBtn()
                .registerUser(user.getName(), user.getEmail(), user.getPassword())
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        Assert.assertTrue("В авторизованном профиле не отображается информационное сообщение!", actual);

    }

    @Test
    @DisplayName("Registration user with valid data through API")
    @Description("Check registration user with valid data through API")
    public void registerNewUserWithApiTest() {

        userSteps.create(user);
        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .isAccountTextDisplayed();
        Assert.assertTrue("В авторизованном профиле не отображается информационное сообщение!", actual);
    }

    @Test
    @DisplayName("Registration user with short password")
    @Description("Check registration user with short password has less 6 symbols")
    public void registerNewUserWithShortPassTest() {
        user.setPassword("4");

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUserWithWrongPassword(user.getEmail(), user.getPassword())
                .isErrorAboutShortPassword();
        Assert.assertTrue("Пароль верный!", actual);
    }

}
