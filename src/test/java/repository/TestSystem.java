package repository;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import system_screens.*;

import java.util.concurrent.TimeUnit;

/**
 * This class is for running tests.
 */
public class TestSystem {
    public static WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

    @BeforeClass
    public void beforeClass() throws Exception {
        driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = XMLUtils.getData("URL");
        driver.get(url);

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");

    }

    @AfterClass
    private static void afterClass(){
        driver.quit();
        extent.flush();
    }

    @Test
    public void login01(){
        String expectedName = "Eden";
        String expectedEmail = "eden.munioz@gmail.com";
        String expectedPassword = "Aa123456";
        String expectedConPassword = "Aa123456";
        IntroRegistrationScreen loginPage = new IntroRegistrationScreen(driver);
        loginPage.login();
        Assert.assertEquals(loginPage.firstName(), expectedName);
        Assert.assertEquals(loginPage.email(), expectedEmail);
        Assert.assertEquals(loginPage.password(), expectedPassword);
        Assert.assertEquals(loginPage.conPassword(),expectedConPassword);
        test.log(Status.INFO, "Login to user");
    }

    @Test
    public void homePage02(){
        HomeScreen homePage = new HomeScreen(driver);
        homePage.homePage();
        test.log(Status.INFO, "Filters to find a gift");
    }

    @Test
    public void pickbusines03(){
        Pickbusiness pickbusines = new Pickbusiness(driver);
        pickbusines.pickbusiness();
        test.log(Status.INFO, "Pick a buisness");
    }

    @Test
    public void receiverInfo04(){
        String expectedName = "עדן";
        ReceiverInfo receiverInfo = new ReceiverInfo(driver);
        receiverInfo.receiverInfo();
        Assert.assertEquals(receiverInfo.ReceiverName(), expectedName);
        test.log(Status.INFO, "Add receiving data");
    }

    @Test
    public void senderInfo05(){
        String expectedName = "הדר";
        SenderInfo senderInfo = new SenderInfo(driver);
        senderInfo.senderinfo();
        Assert.assertEquals(senderInfo.senderName(), expectedName);
        test.log(Status.INFO, "Add sender data");
    }

     @Test
     public void test(){
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div/ul/li[1]/a"));

     }
//    @Test
//    public void loginPage_01(){
//        IntroRegistrationScreen clicklogin = new IntroRegistrationScreen(driver);
//        clicklogin.pressLogin();
//    }
//
//    @Test
//    public void registration_02(){
//        IntroRegistrationScreen clickRegistration = new IntroRegistrationScreen(driver);
//        clickRegistration.pressRegistration();
//    }
//
//    @Test(dependsOnMethods = {"registration_02"})
//    public void firstName(){
//        String expectdNane = "Eden";
//        IntroRegistrationScreen enterName = new IntroRegistrationScreen(driver);
//        enterName.sendKeysToElement(By.cssSelector("input[placeholder='שם פרטי']"), "Eden");
//        String actualName = enterName.firstName();
//        Assert.assertEquals(actualName, expectdNane);
//    }
//
//    @Test(dependsOnMethods = {"registration_02"})
//    public void mailAdress_04(){
//        String expectedMail = "eden.munioz@gmail.com";
//        IntroRegistrationScreen enterEmail = new IntroRegistrationScreen(driver);
//        String actualMail = enterEmail.email();
//        Assert.assertEquals(actualMail, expectedMail);
//    }
//
//    @Test(dependsOnMethods = {"registration_02"})
//    public void password_05(){
//        String expectedPassword = "Aa123456";
//        IntroRegistrationScreen enterPassword = new IntroRegistrationScreen(driver);
//        System.out.println("the password is:" + enterPassword.password());
//        String actualPassword = enterPassword.password();
//        Assert.assertEquals(actualPassword, expectedPassword);
//    }
//
//    @Test(dependsOnMethods = {"registration_02"})
//    public void confirmPassword_06(){
//        String expectedConfirm = "Aa123456";
//        IntroRegistrationScreen enterConPassword = new IntroRegistrationScreen(driver);
//        String actualConfirmPassword = enterConPassword.conPassword();
//        Assert.assertEquals(actualConfirmPassword, expectedConfirm);
//    }
//
//    @Test(dependsOnMethods = {"registration_02"})
//    public void pressRegistration_07(){
//        IntroRegistrationScreen pressReg = new IntroRegistrationScreen(driver);
//        pressReg.pressRegistration();

//    }

//    @Test
//    public void pressOnAmount() {
//        HomeScreen selectAmount = new HomeScreen(driver);
//        selectAmount.pressAmount();

//    }

//    @Test
//    public void test_03(){
//        WebElement testelement1 = driver.findElement(By.cssSelector("input[placeholder='שם פרטי']"));
//        testelement1.sendKeys("eden");

//    }

}
