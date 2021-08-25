package system_screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import repository.BasePage;

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
        assertUrl();
        pickBusiness();
        enterPrice();
    }

    /**
     * The method assert the url presented.
     */
    private void assertUrl(){
        String expectedUrl = "https://buyme.co.il/search?budget=2&category=16&region=13";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    /**
     * The method find an element- pick business and click on it.
     */
    private void pickBusiness(){
        clickElement(By.xpath("//*[@id='ember3792']"));
    }

    /**
     * The method find an element- enter price and click
     */
    private void enterPrice(){
        sendKeysToElement(By.linkText("הכנס סכום"), "500");
        clickElement(By.linkText("button[gtm='בחירה']"));
    }
}
