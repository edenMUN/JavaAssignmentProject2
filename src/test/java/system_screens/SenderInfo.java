package system_screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import repository.BasePage;

/**
 * This class is for defining all find element in the sender Info page.
 */
public class SenderInfo extends BasePage {
    private WebDriver driver;

    /**
     * The method initializes a driver variable.
     * @param driver the driver.
     */
    public SenderInfo(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The method calls all the other methods is this class.
     */
    public void senderinfo(){
        pressSms();
        senderPhone();
        pressPay();
    }

    /**
     * The method find the SMS element and send a phone number.
     */
    private void pressSms(){
        clickElement(By.cssSelector("svg[gtm='method-sms']"));
        clickElement(By.linkText("נייד מקבל/ת המתנה"));
        sendKeysToElement(By.linkText("נייד מקבל/ת המתנה"), "0508233456");
    }

    /**
     * The method find the element's name of the sender and send a name.
     * @return the name.
     */
    public String senderName(){
        WebElement entersenderName = driver.findElement(By.linkText("שם שולח המתנה"));
        entersenderName.sendKeys("עדן");
        return entersenderName.getAttribute("value");
    }

    /**
     * The method find an element- phone sender, and send a phone nubmer.
     */
    private void senderPhone(){
        clickElement(By.linkText("מספר נייד"));
        sendKeysToElement(By.linkText("מספר נייד"), "0508233455");
    }

    /**
     * The method find the continue button and click on it.
     */
    private void pressPay(){
        clickElement(By.cssSelector("button[gtm='המשך לתשלום']"));
    }
}
