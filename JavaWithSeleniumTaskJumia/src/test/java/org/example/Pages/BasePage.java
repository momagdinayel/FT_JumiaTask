package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{
public BasePage(WebDriver driver){
    Hooks.driver = driver;
    PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
}
    public void sendKeys(WebElement Element, String txt) {
        waitToBeClickable(Element,20);
        Element.sendKeys(txt);
    }
    public void waitForVisibility(WebElement Element,Integer EXPLICIT_WAIT) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }
    public void waitToBeClickable(WebElement Element,Integer EXPLICIT_WAIT) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(Element));
    }
    public void clear(WebElement Element) {
        waitForVisibility(Element,20);
        Element.clear();
    }
    public void click(WebElement  Element) {
        waitForVisibility(Element,20);
        Element.click();
    }
    public String getText(WebElement Element){
        waitForVisibility(Element,20);
        return Element.getText();
    }
    public String getAttributes(WebElement Element,String attribute){
    waitForVisibility(Element,20);
    return Element.getAttribute(attribute);
    }
}
