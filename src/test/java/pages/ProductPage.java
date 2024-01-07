package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.Driver;

public class ProductPage {
    public ProductPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final By firstProduct = By.xpath("//div[@id='product-item'][2]//a");
    public final By lastProduct = By.xpath("//div[@id='product-item'][last()]//a");
    public final By addToCart = By.xpath("//div[@class='AddToCart-AddToCartAction']//button");
    public void addFirstItem() throws InterruptedException {
        Thread.sleep(2000);
        Action.clickElement(firstProduct);
        Thread.sleep(2000);
        addToCart();
        Driver.getDriver().navigate().back();
    }
    public void addLastItem() throws InterruptedException {
        Action.scrollToElement(By.xpath("//button[@title='Teknosa Destek']"));
        Thread.sleep(2000);
        Action.clickElementJS(lastProduct);
        Thread.sleep(2000);
        addToCart();
        Driver.getDriver().navigate().back();
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        Action.clickElement(addToCart);
        Thread.sleep(2000);
    }
}
