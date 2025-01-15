package pages;

import org.openqa.selenium.By;

public class MainPage extends AbstractPage{
    private static final String MAIN_URL = "https://yandex.ru";
    private static final By TEXT_INPUT = By.id("text");
    private static final By IMAGE_TAB_LINK = By.xpath("//a[@data-id='images']");

    public MainPage open() {
        driver.get(MAIN_URL);
        return this;
    }

    public MainPage inputText(String text){
        waitForElementPresent(TEXT_INPUT);
        driver.findElement(TEXT_INPUT).clear();
        driver.findElement(TEXT_INPUT).sendKeys(text);
        return this;
    }

    public ImagesPage goToImageTab(){
        waitForElementPresent(IMAGE_TAB_LINK);
        driver.findElement(IMAGE_TAB_LINK).click();
        return new ImagesPage();
    }
}
