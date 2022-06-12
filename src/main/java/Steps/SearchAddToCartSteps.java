package Steps;

import Models.ProductModel;
import Pages.CartPopUpPage;
import Pages.MainPage;
import Pages.ProductPage;
import Pages.SearchPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class SearchAddToCartSteps {
    private static WebDriver driver;
    protected static WebDriverWait wait;
    public static SearchPage searchPage;
    public static ProductPage productPage;
    public static MainPage mainPage;
    public static CartPopUpPage cartPopUpPage;
    public static ProductModel expectedProduct = new ProductModel() ;

    public SearchAddToCartSteps(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        productPage = PageFactory.initElements(this.driver, ProductPage.class);
        cartPopUpPage = PageFactory.initElements(this.driver, CartPopUpPage.class);
        mainPage = PageFactory.initElements(this.driver, MainPage.class);
    }
    @Step
    public SearchAddToCartSteps goTo(String url){
        driver.get(url);
        return this;
    }
    //Alternative way to go main
    @Step("Click to Logo")
    public void logoClick(){
        driver.findElement(mainPage.logoButton).click();
    }
    @Step("Search by word  {0} and go to PageProduct")
    public SearchAddToCartSteps checkSearchByWord(String searchStr) {
        searchPage.inputSearch.clear();
        searchPage.inputSearch.sendKeys(searchStr);
        searchPage.submitSearchButton.click();
        return this;
    }
    @Step("Search by word  {0} and go to PageProduct")
    public boolean checkIfProductPresent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.isPresent));
        if(productPage.product.findElement(productPage.isPresent).getText().equals("Есть в наличии")){
            return true;
        }
        return false;
    }
    @Step("Add to cart")
    public SearchAddToCartSteps addToCart() {
        if (!checkIfProductPresent()) {
            productPage.product.findElement(productPage.anyFirstAdvertisingProduct).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated( productPage.addToCartButton));
        expectedProduct.setProductName(driver.findElement(ProductPage.productTitle).getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(productPage.addToCartButton)).click().perform();
        return this;
    }
    //alternative to close popUp
    @Step("Continue Shopping")
    public SearchAddToCartSteps continueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPopUpPage.continueShoppingButton));
        driver.findElement(cartPopUpPage.continueShoppingButton).click();
        return this;
    }
    @Step("Cart PopUp Close")
    public SearchAddToCartSteps cartPopUpClose(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPopUpPage.cartPopUpClose));
        driver.findElement(cartPopUpPage.cartPopUpClose).click();
        return this;
    }
    @Step("Cart open Cart")
    public SearchAddToCartSteps openCart(){
        driver.findElement(cartPopUpPage.cartButton).click();
        return this;
    }
    @Step("Check added product")
    public SearchAddToCartSteps checkAddedProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPopUpPage.productList));
        String productNameInCart = driver.findElement(cartPopUpPage.productTitle).getText();
        Assert.assertEquals(productNameInCart, expectedProduct.getProductName());
        return this;
    }

}
