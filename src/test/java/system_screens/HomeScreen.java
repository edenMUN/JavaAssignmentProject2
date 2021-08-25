package system_screens;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import repository.BasePage;

/**
 * This class is for defining all find element in the home screen page.
 */
public class HomeScreen extends BasePage {
    private WebDriver driver;

    /**
     * The method initializes a driver variable.
     * @param driver the driver.
     */
    public HomeScreen(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The method calls all the other methods is this class.
      */
    public void homePage(){
        pressAmount();
        pressArea();
        pressCategory();
        pressFindGift();
    }

    /**
     * The method find an element- press amount, click on it and select one.
     */
    private void pressAmount(){
        clickElement(By.linkText("סכום"));
        clickElement(By.cssSelector("li[data-option-array-index='2']"));
    }

    /**
     * The method find an element- press area, click on it and select one.
     */
    private void pressArea(){
        clickElement(By.linkText("אזור"));
        clickElement(By.cssSelector("li[data-option-array-index='1']"));
    }

    /**
     * The method find an element- press category, click on it and select one.
     */
    private void pressCategory(){
        clickElement(By.linkText("קטגוריה"));
        clickElement(By.cssSelector("li[data-option-array-index='2']"));
    }

    /**
     * The method find an element-find gift and click on it.
     */
    private void pressFindGift(){
        clickElement(By.linkText("תמצאו לי מתנה"));
    }
}
