package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProductPage;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @And("user adds the first item to basket")
    public void userAddsTheFirstItemToTheBasket() throws InterruptedException {
        productPage.addFirstItem();
    }

    @And("user adds the last item to basket")
    public void userAddsTheLastItemToTheBasket() throws InterruptedException {
        productPage.addLastItem();
    }
}
