package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.Driver;

public class LoginPage
{
    public LoginPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public final By withoutRegisterButton = By.xpath("//a[@title=\"Üye Olmadan Devam Et\"]");
    public final By guestEmailAddressInput = By.xpath("//input[@id=\"guest.email\"]");

    public void clickWithoutRegister()
    {
        Action.clickElement(withoutRegisterButton);
    }

    public void sendEmailAddress(String text) throws InterruptedException {
        Action.sendKeysElement(guestEmailAddressInput, text);
        Thread.sleep(6000);
    }
}
