import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.internal.Utils.copyFile;

public class TestForTonic {

    private WebDriver driver;

    @BeforeClass

    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium Tests\\geckodriver-v0.15.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test

    public void gotoTHPage() throws InterruptedException {
        driver.get("https://www.yahoo.com/");
        driver.findElement(By.id("uh-search-box")).sendKeys("Tonic For Health");
        driver.findElement(By.id("uh-search-button")).click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By
                        .linkText("Tonic Health | Refreshing Medical Data Collection"))).click();

        /** ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

         driver.switchTo().window(tabs2.get(0));
         driver.close();
         ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
         driver.switchTo().window(tabs1.get(0));
         **/

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        copyFile(scrFile, new File("D:\\111111\\scrnsht.jpg"));

    }

    @AfterClass
    public void Close() {

      //  driver.quit();
    }

}

