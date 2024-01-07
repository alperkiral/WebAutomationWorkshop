package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.StorePage;
import utils.Action;
import utils.Driver;

import java.io.IOException;

public class StoreSteps {
    StorePage storePage = new StorePage();

    @And("the user selects {string} and {string} from search box")
    public void theUserSelectsCityAndStateFromSearchBox(String city, String state) throws InterruptedException {
        storePage.selectCity(city);
        storePage.selectState(state);
    }

    @Then("listed stores in {string}, {string} should be saved into a text file")
    public void listedStoresShouldBeSavedIntoATextFile(String city, String state) throws IOException {
        storePage.writeStoresToTxt(city, state);
    }
}
