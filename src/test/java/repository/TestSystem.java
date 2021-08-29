package repository;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import system_screens.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class is for running tests.
 */
public class TestSystem {
    public static WebDriver driver;
    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("Java Project 2- BuyMe", "Sanity Test");

    @BeforeClass
    public void beforeClass() throws Exception {
        driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = XMLUtils.getData("URL");
        driver.get(url);

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter( "./report.html");
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
        String expectedName = "eitanmunmm1";
        String expectedEmail = "eitanmunmm1.munioz@gmail.com";
        String expectedPassword = "Aa1234567";
        String expectedConPassword = "Aa1234567";
        IntroRegistrationScreen loginPage = new IntroRegistrationScreen(driver);
        loginPage.login();
        Assert.assertEquals(loginPage.firstName(), expectedName);
        Assert.assertEquals(loginPage.email(), expectedEmail);
        Assert.assertEquals(loginPage.password(), expectedPassword);
        Assert.assertEquals(loginPage.conPassword(),expectedConPassword);
        loginPage.registration();
        test.log(Status.INFO, "Login to user");
    }

    @Test (dependsOnMethods = {"login01"})
    public void homePage02(){
        HomeScreen homePage = new HomeScreen(driver);
        homePage.homePage();
        test.log(Status.INFO, "Filters to find a gift");
    }

    @Test (dependsOnMethods = {"homePage02"})
    public void pickbusines03(){
        Pickbusiness pickbusines = new Pickbusiness(driver);
        pickbusines.pickbusiness();
        test.log(Status.INFO, "Pick a buisness");
    }

    @Test (dependsOnMethods = {"pickbusines03"})
    public void receiverInfo04(){
        String expectedName = "הדר";
        ReceiverInfo receiverInfo = new ReceiverInfo(driver);
        receiverInfo.receiverInfo();
        Assert.assertEquals(receiverInfo.ReceiverName(), expectedName);
        test.log(Status.INFO, "Add receiving data");
    }

    @Test (dependsOnMethods = {"receiverInfo04"})
    public void senderInfo05(){
        String expectedName = "הדר";
        SenderInfo senderInfo = new SenderInfo(driver);
        senderInfo.senderinfo();
        Assert.assertEquals(senderInfo.senderName(), expectedName);
        test.log(Status.INFO, "Add sender data");
    }

}
