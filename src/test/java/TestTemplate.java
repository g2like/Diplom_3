import data.API;
import data.UserData;
import generator.GeneratorRandomUser;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

public class TestTemplate {
    WebDriver driver;
    UserSteps userSteps;
    UserData user;
    private String bearerToken;

    @Before
    public void setup() {

        driver = Browser.getDriver(BrowserType.YANDEX);
        driver.get(API.BASE_URL);
        user = GeneratorRandomUser.getRandomUser();
        userSteps = new UserSteps();
    }

    @After
    public void teardown() {
        driver.quit();
        if (user != null) {
            ValidatableResponse responseLogin = userSteps.login(user);
            bearerToken = responseLogin.extract().path("accessToken");
            if (bearerToken == null) {
                return;
            }
            userSteps.delete(bearerToken);
        }
    }
}
