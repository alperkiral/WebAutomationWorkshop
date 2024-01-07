package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Action;
import utils.Driver;

public class SearchPage {

    public SearchPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
