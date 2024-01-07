package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Action;
import utils.Driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StorePage {

    public StorePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void selectCity(String city) throws InterruptedException {
        Action.clickElementJS(By.xpath("//button[@class='dismissButton']"));
        Thread.sleep(500);
        Driver.getDriver().findElement(By.xpath("//select[@id='cities1']/option[contains(text(),'" + city + "')]")).click();
        Thread.sleep(500);
    }

    public void selectState(String state) throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//select[@id='towns']/option[contains(text(),'"+ state +"')]")).click();
        Thread.sleep(500);
    }

    public void writeStoresToTxt(String city, String state) throws IOException {
        String testFile = "stores_" + city + "_" + state + ".txt";
        File FC = new File(testFile);
        FC.createNewFile();

        FileWriter FW = new FileWriter(testFile);
        BufferedWriter BW = new BufferedWriter(FW);
        List<WebElement> strElements = Driver.getDriver().findElements(By.cssSelector(".stp-list-items .str"));
        System.out.println("Store List Size: " + strElements.size());
        for(int i = 1; i <= strElements.size(); i++)
        {
            BW.write(Action.getTextElement(By.xpath("(//div[@class='str-title'])["+i+"]")));
            BW.newLine();
            BW.write(Action.getTextElement(By.xpath("(//div[@class='str-address'])["+i+"]")));
            BW.newLine();
            BW.write(Action.getTextElement(By.xpath("(//div[@class='str-tel'])["+i+"]")));
            BW.newLine();
            BW.write(Action.getTextElement(By.xpath("(//div[@class='str-hours'])["+i+"]")));
            BW.newLine();
            BW.write("***");
            BW.newLine();
        }
        BW.write("-------------------------------");
        BW.close();
    }
}
