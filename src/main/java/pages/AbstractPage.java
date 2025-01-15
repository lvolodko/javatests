package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

public abstract class AbstractPage {
    private static final int DEFAULT_TIMEOUT = 10;
    protected WebDriver driver;

    protected AbstractPage() {
        this.driver = WebDriverSingleton.getInstance();
    }

    protected boolean isElemetPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }

    protected void waitForElementPresent(By locator){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementVisible(By locator){
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
