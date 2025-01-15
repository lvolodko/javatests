import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ImagesPage;
import pages.MainPage;
import pages.SelectItemPopup;
import utils.WebDriverSingleton;

import java.util.List;

/**
 * @date 10.2019
 * @author Liubov
 */
 public class YandexTest{
    private static final Logger LOG = Logger.getLogger(YandexTest.class);
    private MainPage mainPage = new MainPage();

    @DataProvider(name = "data")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "Погода" },
                                { "Липецк" },
                                { "Лото" } };
    }

    @Test(dataProvider= "data", description = "Parse first item from drop down list test")
    public void parseListOfSearchedTextTest(String data) throws InterruptedException {
        LOG.info("Start test");
        mainPage.open().inputText(data);
        SelectItemPopup selectItemPopup = new SelectItemPopup();
        List<String> items = selectItemPopup.getListItems();
        LOG.info("List of items: " + items.get(0).trim().replace("\n"," "));
    }

    @Test(description = "Verify images page test")
    public void visibilityTabImagesTest() {
        ImagesPage ip = mainPage.open().goToImageTab();
        List<WebElement> list = ip.getListItems();
        Assert.assertTrue(ip.getTitle().contains("Картинки"), "Image page dosen't contain title");

        int brokenImage = 0;
        for(int i=0; i < 10; ++i){
            if (ip.getWidthImages(list.get(i)) < 1){
                brokenImage++;
            }
        }
        Assert.assertTrue(brokenImage == 0, "There are broken images on the page");
    }

    @AfterTest()
    public void close(){
        WebDriverSingleton.kill();
    }
}
