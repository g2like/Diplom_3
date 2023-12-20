import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class SignOutTest extends TestTemplate {
    @Test
    @DisplayName("Sign out from account authorization user")
    @Description("Check sign out from account authorization user")
    public void canSingOutFromProfileTest() {
        userSteps.create(user);

        Boolean actual = new MainPage(driver)
                .clickPersonalAccountBtn()
                .signInUser(user.getEmail(), user.getPassword())
                .clickPersonalAccountBtnWithAuthorizedUser()
                .clickSingOutBtn()
                .isSignInBtnDisplayed();
        Assert.assertTrue("Пользователь все еще авторизован!", actual);
    }
}
