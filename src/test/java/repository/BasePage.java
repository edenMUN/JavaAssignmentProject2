package repository;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static repository.DriverSingleton.takeScreenShot;

/**
 * This class is for defining methods to find the elements.
 */
public class BasePage {
    WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

    /**
     * The method is to find an element and click on it.
     * @param locator of the element.
     */
    public void clickElement(By locator) {
        try {
            getWebElement(locator).click();
        }catch (NoSuchElementException e){
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "picName")).build());
        }
    }

    /**
     * The method to find an element and send a key to the element.
     * @param locator of the element.
     * @param text you want to write in the element.
     */
    public void sendKeysToElement(By locator, String text) {
        try {
            getWebElement(locator).sendKeys(text);
        }catch (NoSuchElementException e){
            test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(driver, "picName")).build());
        }
    }

    /**
     * The method creates the driver.
     * @param locator of the element.
     * @return the picture of the screenshot page.
     */
    private WebElement getWebElement(By locator) {
            return DriverSingleton.getDriverInstance().findElement(locator);
    }

}
