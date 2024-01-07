package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.Driver;

public class Page {

    // Define Xpaths
    public Page()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final By notificationAccept = By.xpath("//div[@data-bind-menu=\"notification|text_editing\"][contains(text(),'Tamam')]");
//    WebElement root = Driver.getDriver().findElement(By.cssSelector("div:nth-child(4) > div:nth-child(1)")) ;
//    SearchContext shadow = root.getShadowRoot();
//    WebElement accept = shadow.findElement(By.xpath("//div[@data-name='Accept Button']"));

//    public void acceptCookies(){
//        accept.click();
//    }
}
