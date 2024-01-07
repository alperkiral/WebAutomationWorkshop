package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Page;

public class Steps {

    Page page = new Page();

    @Given("user accepts cookies")
    public void userAcceptsCookies(){
//        page.acceptCookies();
    }
}
