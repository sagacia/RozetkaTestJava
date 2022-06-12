package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    @FindBy(xpath = "//div[contains(@id, '#scrollArea')]")
    public static WebElement product;
    public static By productTitle = By.xpath("//div[@class='product__heading']");
    public static By isPresent = By.xpath("//*[contains(@class, 'status-label')]");
    public static By addToCartButton = By.xpath("//span[contains(@class, 'buy-button__label')]");
    public static By anyFirstAdvertisingProduct = By.xpath("//section[contains(@class, 'product-sponsored')]//a[contains(@class,'lite-tile__title')][1]");



}
