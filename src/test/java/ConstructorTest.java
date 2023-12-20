import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class ConstructorTest extends TestTemplate {
    @Test
    @DisplayName("Transfer to catalog of Buns")
    @Description("Check open catalog with buns")
    public void openCatalogBunsTest() {
        Boolean actual = new MainPage(driver)
                .clickSaucesBtn()
                .clickBunBtn()
                .isBunsIsDisplayed();

        Assert.assertTrue("Вкладка Булки не отображается!", actual);
    }

    @Test
    @DisplayName("Transfer to catalog of Sauces")
    @Description("Check open catalog with sauces")
    public void openCatalogSaucesTest() {
        Boolean actual = new MainPage(driver)
                .clickSaucesBtn()
                .isSaucesIsDisplayed();
        Assert.assertTrue("Вкладка Соусы не отображается!", actual);
    }

    @Test
    @DisplayName("Transfer to catalog of Fillings")
    @Description("Check open catalog with fillings")
    public void openCatalogFillingsTest() {
        Boolean actual = new MainPage(driver)
                .clickFillingsBtn()
                .isFillingsIsDisplayed();
        Assert.assertTrue("Вкладка Начинки не отображается!", actual);
    }

}
