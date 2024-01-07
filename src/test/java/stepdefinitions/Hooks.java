package stepdefinitions;

import io.cucumber.java.After;

import io.cucumber.java.Before;
import utils.ConfigurationReader;
import utils.Driver;

public class Hooks {
    @Before
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @After
    public void ending()
    {
        Driver.closeDriver();
    }


}
