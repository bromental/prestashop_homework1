package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        BaseScript.loginAdmin(driver);
        By menuLocator = By.xpath("//ul[@class='menu' or @class='main-menu']/li[contains(@class, 'maintab') or contains(@class, 'link-levelone')]");
        BaseScript.waitFor(menuLocator, driver);

        List<WebElement> adminMainMenu = driver.findElements(menuLocator);
        int count = adminMainMenu.size();
        for (int i = 0; i < count; i++) {
            BaseScript.waitFor(menuLocator, driver);
            WebElement menuItem = driver.findElements(menuLocator).get(i);
            menuItem.click();

            By titleLocator = By.xpath("//h2[@class='page-title' or @class='title']");
            String title = driver.findElement(titleLocator).getText();
            System.out.println(title);

            driver.navigate().refresh();
            BaseScript.waitFor(titleLocator, driver);

            System.out.println("The page is the same after refresh: " + title.equals(driver.findElement(titleLocator).getText()));
        }

        driver.quit();
    }
}
