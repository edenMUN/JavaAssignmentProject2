package system_screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import repository.BasePage;

import java.util.List;

/**
 * This class is for defining all find element in the pick business page.
 */
public class Pickbusiness extends BasePage {
    private WebDriver driver;

    /**
     * The method initializes a driver variable.
     * @param driver the driver.
     */
    public Pickbusiness(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The method calls all the other methods is this class.
     */
    public void pickbusiness(){
//        assertUrl();
        pickBusiness();
        enterPrice();
    }

    /**
     * The method assert the url presented.
     */
//    private void assertUrl(){
//        String expectedUrl = "https://buyme.co.il/?modal=login";
//        String actualUrl = driver.getCurrentUrl();
//        Assert.assertEquals(actualUrl, expectedUrl);
//    }

    /**
     * The method find an element- pick business and click on it.
     */
    private void pickBusiness(){
        List<WebElement> test = driver.findElements(By.className("bm-product-cards"));
        test.get(0).click();
    }

    /**
     * The method find an element- enter price and click
     */
    private void enterPrice(){
        clickElement(By.cssSelector("input[placeholder='הכנס סכום']"));
        sendKeysToElement(By.cssSelector("input[placeholder='הכנס סכום']"), "500.00");
        clickElement(By.className("money-btn"));
    }
}
