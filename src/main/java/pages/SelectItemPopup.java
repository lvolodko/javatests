package pages;

import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SelectItemPopup extends AbstractPage{
    private static final By POPUP_LOCATOR = By.xpath(".//div[@class='popup__content']");
    private static final By LIST_ITEMS = By.className("suggest2-item");

    public List<String> getListItems(){
        waitForElementPresent(POPUP_LOCATOR);
        return driver.findElements(LIST_ITEMS)
                .stream()
                .map(item -> item.getText()).collect(Collectors.toList());
    }
}
