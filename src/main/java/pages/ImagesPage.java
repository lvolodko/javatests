package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ImagesPage extends AbstractPage {
    private static final By PICTURE_LOCATOR = By.cssSelector("img.cl-picture__image");
    private static final By TITLE_LOCATOR = By.xpath("//meta[@name='title']");

    public List<WebElement> getListItems(){
        waitForElementPresent(PICTURE_LOCATOR);
        return driver.findElements(PICTURE_LOCATOR);
    }

    public String getTitle(){
        waitForElementPresent(TITLE_LOCATOR);
        return driver.findElement(TITLE_LOCATOR).getAttribute("content");
    }

    public int getWidthImages(WebElement element){
        return Integer.parseInt(element.getAttribute("naturalWidth"));
    }
}
