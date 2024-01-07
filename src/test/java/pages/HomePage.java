package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.Driver;

public class HomePage {
    public HomePage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public final By storeLink = By.xpath("//button[contains(text(), 'Kurumsal')]/..//a[contains(text(), 'Mağazalarımız')]");
    public final By searchBarInput = By.xpath("//input[@id='search-input']");
    public final By searchBarButton = By.xpath("//button[contains(@class,'search-button')]");

    public void clickToStores(){
        Action.clickElementJS(storeLink);
    }

    public void searchFor() throws InterruptedException {
        Action.clickElementJS(searchBarButton);
        Action.sendKeysElement(searchBarInput, "Ku");
        Thread.sleep(300);
        Action.sendKeysElement(searchBarInput, "lak");
        Thread.sleep(300);
        Action.sendKeysElement(searchBarInput, "l");
        Thread.sleep(500);
        Action.sendKeysElement(searchBarInput, "ı");
        Thread.sleep(500);
        Action.sendKeysElement(searchBarInput, "k");
        Thread.sleep(500);
        Thread.sleep(1000);
    }

    public void clickToSubCategory(String text)
    {
        Action.clickElement(By.xpath("//a[@title='" + text + "'][@class='categoryList']"));
    }
}
