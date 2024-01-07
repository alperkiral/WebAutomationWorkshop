package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @When("the user clicks to Stores on Footer")
    public void theUserClicksToStoresOnFooter() {
        homePage.clickToStores();
    }


    @When("user searches for kulaklık")
    public void userSearchesFor() throws InterruptedException {
        homePage.searchFor();
    }

    @And("user selects {string} from the subcategory")
    public void userSelectsFromTheSubcategory(String text)
    {
        homePage.clickToSubCategory(text);
    }
}
