package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Action {

    public static By compareAndGetCheap(By xpathA, By xpathB)
    {
        float A = Float.parseFloat(Action.getValueElement(xpathA));
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA"+A);
        float B = Float.parseFloat(Action.getValueElement(xpathB));
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBB"+B);
        if(A < B)
        {
            System.out.println("if");
            return xpathA;
        }
        System.out.println("return");
        return xpathB;
    }
    public static WebElement findElementXpath(By xpath)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        return Driver.getDriver().findElement(xpath);
    }
    public static void pressEnter(By xpath)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.sendKeys(Keys.ENTER);
    }
    public static void clickElement(By xpath) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.click();
    }

    public static void clickElementJS(By xpath)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void sendKeysElement(By xpath, String key)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.sendKeys(key);
    }

    public static String getTextElement(By xpath)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        return element.getText();
    }

    public static String getValueElement(By xpath)
    {
        WebElement element = Driver.getDriver().findElement(xpath);
        return element.getAttribute("value");
    }

    public static void checkElementText(By xpath, String text)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        Assert.assertEquals(element.getText(), text);
    }

    public static void moveToElement(By xpath)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    public static void scrollToElement(By xpath)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }
}
