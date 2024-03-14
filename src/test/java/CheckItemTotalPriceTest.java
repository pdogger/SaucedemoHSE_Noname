import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.Converter.getPrice;

public class CheckItemTotalPriceTest extends BaseTest {

    @Test(description = "Проверка общей стоимости выбранных товаров")
    public void test() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Backpack")
                .addToCart("Sauce Labs Onesie")
                .clickCart()
                .clickCheckOut()
                .fillingForm("Username", "Username", "123456");
        Assert.assertEquals(getPrice(checkoutOverviewPage.getItemTotalPrice()),
                checkoutOverviewPage.calcItemTotalPrices());
    }
}
