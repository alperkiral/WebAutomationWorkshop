package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.Driver;

import static java.lang.Integer.parseInt;

public class BasketPage {
    public BasketPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public final By cartButton = By.xpath("//button[@aria-label='sepetim']");
    public final By goToCartButton = By.xpath("//a[@title='Sepetim’e Git']");
    public final By firstItemInBasket = By.xpath("(//form[contains(@id, 'updateCartForm')])[2]/input[@name='productPrice']");
    public final By secondItemInBasket = By.xpath("(//form[contains(@id, 'updateCartForm')])[1]/input[@name='productPrice']");
    public final By checkoutButton = By.xpath("//a[@title='Alışverişi Tamamla']");
    public void goToBasket() throws InterruptedException {
        Thread.sleep(2000);
        Action.clickElement(cartButton);
        Thread.sleep(2000);
        Action.clickElement(goToCartButton);
    }

    public void compareAndIncreaseTheCheap(int amount) throws InterruptedException {
        By cheapPrice = Action.compareAndGetCheap(firstItemInBasket, secondItemInBasket);
        String plusButtonXpath = cheapPrice.toString().split(":")[1].trim() + "/..//button[@class='plus  quantity-right-plus']";
        for(int i = 1; i< amount;)
        {
            Thread.sleep(2000);
            Action.clickElement(By.xpath(plusButtonXpath));
            i++;
        }
    }

    public void clickCheckout() throws InterruptedException {
        Thread.sleep(2000);
        Action.clickElement(checkoutButton);
        Thread.sleep(2000);
    }
}
