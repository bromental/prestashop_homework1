package myprojects.automation.assignment2;

import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
            return new FirefoxDriver();
        } else if (browser.equals(BrowserType.IE)) {
            System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\IEDriverServer.exe");
            return new InternetExplorerDriver();
        }

        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver2.exe");
        return new ChromeDriver();
    }

    public static void loginAdmin(WebDriver driver) {

        driver.get(Properties.getBaseAdminUrl());

        WebElement emailForm = driver.findElement(By.id("email"));
        emailForm.sendKeys(Properties.getLOGIN());

        WebElement passwordForm = driver.findElement(By.id("passwd"));
        passwordForm.sendKeys(Properties.getPASSWORD());

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='submitLogin']"));
        loginButton.click();
    }

    public static void waitFor(By locator, WebDriver driver){
        WebDriverWait wait3 = new WebDriverWait(driver, 5);
        wait3.until(ExpectedConditions.elementToBeClickable(locator));
    }
}