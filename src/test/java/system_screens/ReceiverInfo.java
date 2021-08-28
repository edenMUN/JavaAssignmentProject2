package system_screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import repository.BasePage;

/**
 * This class is for defining all find element in the receiver info page.
 */
public class ReceiverInfo extends BasePage {
    private WebDriver driver;

    /**
     * The method initializes a driver variable.
     * @param driver the driver.
     */
    public ReceiverInfo(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The method calls all the other methods is this class.
     */
    public void receiverInfo() {
        pressRadioButton();
        enterBlessing();
        pickEvent();
        UploadPicture();
        pressContinue();
    }

    /**
     * The method find an element to whom send the gift and click on it.
     */
    private void pressRadioButton(){
        clickElement(By.cssSelector("div[gtm='למישהו אחר']"));
    }

    /**
     * The method find an element- receiver name and send a name.
     * @return the name field value.
     */
    public String ReceiverName(){
        WebElement receiverName = driver.findElement(By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']"));
        receiverName.click();
        receiverName.sendKeys("הדר");
        return receiverName.getAttribute("value");
    }

    /**
     * The method find an element- the event and click on the option selected.
     */
    private void pickEvent() {
        clickElement(By.className("selected-name"));
        clickElement(By.cssSelector("li[value='10']"));
    }

    /**
     * The method find an element- enter blessing, click on is and send a blessing.
     */
    private void enterBlessing(){
        clickElement(By.cssSelector("textarea[data-parsley-group='voucher-greeting']"));
        driver.findElement(By.cssSelector("textarea[data-parsley-group='voucher-greeting']")).clear();
        sendKeysToElement(By.cssSelector("textarea[data-parsley-group='voucher-greeting']"), "מזל טוב:)");
    }

    /**
     * The method fins an element- upload picture and upload a picture to the website.
     */
    private void UploadPicture(){
        sendKeysToElement(By.className("bm-media-upload"), "C:\\Users\\edenmm\\Desktop\\download.jfif");
    }

    /**
     * The method find an element- continue and click on it.
     */
    private void pressContinue(){
        clickElement(By.cssSelector("button[gtm='המשך']"));
    }
}
