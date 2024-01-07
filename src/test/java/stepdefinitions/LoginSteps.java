package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utils.ConfigurationReader;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @And("user clicks continue without register")
    public void userClicksContinueWithoutRegister()
    {
        loginPage.clickWithoutRegister();
    }

    @Then("user enters the email address for")
    public void userEntersTheEmailAddressFor() throws InterruptedException {
        loginPage.sendEmailAddress(ConfigurationReader.properties.getProperty("email"));
    }
}
