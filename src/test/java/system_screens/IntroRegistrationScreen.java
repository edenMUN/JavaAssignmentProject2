package system_screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import repository.BasePage;
import repository.Constants;

/**
 * This class is for defining all find element in the intro registration screen page.
 */
public class IntroRegistrationScreen extends BasePage {
    private WebDriver driver;

    /**
     * The method initializes a driver variable.
     * @param driver the driver.
     */
    public IntroRegistrationScreen(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * The method calls all the other methods is this class.
     */
    public void login() {
        pressLogin();
        pressRegistration();
    }

    /**
     * The method fint the login element and click on it.
     */
    private void pressLogin(){
        clickElement(By.className("seperator-link"));
    }

    /**
     * The method find the egistration button and click on it.
     */
    private void pressRegistration(){
        clickElement(By.className("text-link"));
    }

    /**
     * The method find the fist name element and send a name.
     * @return the name field value.
     */
    public String firstName(){
        String name = "eitanmunmm1";
        sendKeysToElement(By.cssSelector("input[placeholder='שם פרטי']"), name);
        return name;
    }

    /**
     * The method find email element and send a email.
     * @return the email field value.
     */
    public String email(){
        WebElement enterEmail = driver.findElement(Constants.EMAIL);
        enterEmail.sendKeys("eitanmunmm1.munioz@gmail.com");
        return enterEmail.getAttribute("value");
    }

    /**
     * The method find password element and send a password.
     * @return password field value.
     */
    public String password(){
        WebElement enterPassword = driver.findElement(Constants.PASSWORD);
        enterPassword.sendKeys("Aa1234567");
        return enterPassword.getAttribute("value");
    }

    /**
     * The method find confirmation password element and send a password.
     * @return confirmation password field value.
     */
    public String conPassword(){
        WebElement enterPassword = driver.findElement(Constants.CONFIRM_PASSWORD);
        enterPassword.sendKeys("Aa1234567");
        return enterPassword.getAttribute("value");
    }

    /**
     * The method find registration button element and click on it.
     */
    public void registration(){
        clickElement(By.cssSelector("button[gtm='הרשמה ל-BUYME']"));
        }
}
