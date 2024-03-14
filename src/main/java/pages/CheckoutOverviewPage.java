package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.Converter.getPrice;

public class CheckoutOverviewPage {

    WebDriver driver;
    By itemPrice = By.xpath("//div[@class = 'inventory_item_price']");
    By itemTotalPrice = By.xpath("//div[@class = 'summary_subtotal_label']");
    By taxPrice = By.xpath("//div[@class = 'summary_tax_label']");
    By totalPrice = By.xpath("//div[@class = 'summary_total_label']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemTotalPrice() {
        return driver.findElement(itemTotalPrice).getText();
    }

    public String getTaxPrice() {
        return driver.findElement(taxPrice).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public List<String> getItemPrices() {
        List<WebElement> items = driver.findElements(itemPrice);
        List<String> ItemPriceList = new ArrayList<>();
        for (WebElement item: items) {
            ItemPriceList.add(item.getText());
        }
        return ItemPriceList;
    }

    public Double calcItemTotalPrices() {
        Double ItemTotalPriceCalculated = 0.0;
        for (String itemPrice: getItemPrices()) {
            ItemTotalPriceCalculated += getPrice(itemPrice);
        }
        return ItemTotalPriceCalculated;
    }
}
