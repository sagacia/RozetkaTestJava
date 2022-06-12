package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopUpPage {
    public static By cartButton = By.xpath("//li[contains(@class, 'cart')]//button");
    public static By continueShoppingButton = By.xpath("//button[@data-testid='continue-shopping-link']");
    public static By cartPopUpClose = By.xpath("//button[@class='modal__close']");
    public static By productList = By.xpath("//ul[contains(@class, 'cart-list')]");
    public static By productTitle = By.xpath("//a[@class='cart-product__title']");

}
