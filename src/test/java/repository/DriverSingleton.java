package repository;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * This class is for defining the creation od the driver.
 */
public class DriverSingleton {
    private static WebDriver driver;

    /**
     * The method initializes only one driver as defined in the data XML file.
     * @return the driver initialized.
     */
    public static WebDriver getDriverInstance(){
        if(driver == null){
            String type  = null;
            try {
                type = XMLUtils.getData("browserType");
                if (type.equals("Chrome")){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\edenmm\\Downloads\\chromedriver_win32\\chromedriver.exe");
                    driver = new ChromeDriver();
                }else if (type.equals("FF")){
                    System.setProperty("webdriver.firefox.driver", "C:\\Users\\edenmm\\Downloads\\geckodriver-v0.29.1-win64.zip\\geckodriver.exe");
                    driver = new FirefoxDriver();
                }
            } catch (Exception e) {
                e.printStackTrace();
                takeScreenShot(driver, ".png");
            }
        }
        return driver;
    }

    /**
     * The method take screenshot of the webPage
     * @param driver
     * @param ImagesPath
     * @return the saved image.
     */
    static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}
