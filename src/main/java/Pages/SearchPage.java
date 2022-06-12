package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage  {
    @FindBy(xpath = "//input[contains(@class, 'search-form__input')]")
    public static WebElement inputSearch;
    @FindBy(xpath = "//*[contains(@class, 'search-form__submit')]")
    public static WebElement submitSearchButton;










}
