package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseScript {

    public static void main(String[] args) {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        BaseScript.loginAdmin(driver);

        By employeesInfoLocator = By.id("employee_infos");
        BaseScript.waitFor(employeesInfoLocator, driver);

        WebElement userIcon = driver.findElement(employeesInfoLocator);
        userIcon.click();

        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

        driver.quit();
    }
}
