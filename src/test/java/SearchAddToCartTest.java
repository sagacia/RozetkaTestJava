import Pages.CartPopUpPage;
import Steps.*;
import WebSettings.WebDriverSetup;
import WebElementBlocks.URLs;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchAddToCartTest extends WebDriverSetup {
    public static SearchAddToCartSteps searchAddToCartSteps;

    @BeforeTest
    public void start(){
        searchAddToCartSteps = PageFactory.initElements(driver, SearchAddToCartSteps.class);
    }
    @AfterTest
    public void quitDriver(){
       driver.quit();
    }
    @DataProvider
    public Object[][] DataProviderSrchStr(){
        return new Object[][]{
                {"MD506Z/A"}
               ,{"219496051"}
               ,{"10659212"}//out of stock
             //  ,{"10678826"}//out of stock
        };
    }
    @Test(dataProvider = "DataProviderSrchStr")
    public void SearchAddToCart(String searchStr) {

        searchAddToCartSteps.goTo(URLs.mainPage)
                .checkSearchByWord(searchStr)
                .addToCart()
                .cartPopUpClose()
                .goTo(URLs.mainPage)
                .openCart()
                .checkAddedProduct();
    }

}