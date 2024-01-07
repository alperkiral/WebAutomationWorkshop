package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import pages.BasketPage;
import utils.Driver;

public class BasketSteps {

    BasketPage basketPage = new BasketPage();

    @And("user navigates to basket")
    public void userNavigatesToBasket() throws InterruptedException {
        basketPage.goToBasket();
    }

    @And("user increases the amount of the cheapest item to {int}")
    public void userIncreasesTheAmountOfTheCheapestItemTo(int amount) throws InterruptedException {
        basketPage.compareAndIncreaseTheCheap(amount);
    }

    @And("user clicks to checkout")
    public void userClicksToCheckout() throws InterruptedException {
        basketPage.clickCheckout();
    }
}
