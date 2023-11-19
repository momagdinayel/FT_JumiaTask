package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import static org.example.StepDefinition.Hooks.driver;

public class P01_RegisterPage extends BasePage{

    public P01_RegisterPage() {
        super(driver);
    }
    public WebElement closeAdButton(){
        By closeAdButton=By.xpath("//*[@id=\"pop\"]/div/section/button");
        return driver.findElement(closeAdButton);
    }
    public WebElement accountButton(){
        By accountButton=By.xpath("//*[@id=\"dpdw-login\"]/parent::*");
        return driver.findElement(accountButton);
    }
    public WebElement signIn(){
        By signIn=By.xpath("//a[contains(.,'Sign')]");
        return driver.findElement(signIn);
    }
    public WebElement emailField(){
        By emailField=By.id("input_identifierValue");
        return driver.findElement(emailField);
    }
    public WebElement continueButton(){
        By continueButton=By.xpath("//button[contains(.,'Continue')]");
        return driver.findElement(continueButton);
    }
    public WebElement emailLabel(){
        By emailLabel=By.xpath("//*[@class=\"identity-container-username\"]");
        return driver.findElement(emailLabel);
    }
    public WebElement passwordField(){
        By passwordField =By.xpath("//*[@id=\"card_password\"]/div[3]/label/input");
        return driver.findElement(passwordField);
    }
    public WebElement confirmPasswordField(){
        By confirmPasswordField=By.xpath("//*[@id=\"card_password\"]/div[4]/label/input");
        return driver.findElement(confirmPasswordField);
    }
    public WebElement continueButtonTwo(){
        By continueButtonTwo=By.xpath("//*[@id=\"card_password\"]/div[5]/div/button/span[1]");
        return driver.findElement(continueButtonTwo);
    }
    public WebElement firstName(){
        By firstName=By.id("input_first_name");
        return driver.findElement(firstName);
    }
    public WebElement lastName(){
        By lastName=By.id("input_last_name");
        return driver.findElement(lastName);
    }
    public WebElement phoneNumber(){
        By phoneNumber=By.xpath("//span[contains(.,'Phone Number')]/following-sibling::input");
        return driver.findElement(phoneNumber);
    }
    public WebElement continueButtonThree(){
        By continueButtonThree=By.xpath("//*[@id=\"card_profile_details\"]/div[5]/div/button/span[3]");
        return driver.findElement(continueButtonThree);
    }
    public WebElement gender(){
        By gender=By.id("gender");
        return driver.findElement(gender);
    }
    public By birthDate(){
        return By.id("input_birth_date");
    }
    public WebElement acceptTC(){
        By acceptTC=By.id("acceptTC");
        return driver.findElement(acceptTC);
    }
    public WebElement continueLastButton(){
        By continueLastButton=By.id("confirmBtn");
        return driver.findElement(continueLastButton);
    }
    public WebElement genderType(String type){
        WebElement gender=null;
        if(type.equalsIgnoreCase("male")){
            gender= driver.findElement(By.xpath("//span[contains(.,'Male')]"));
        }
        else if(type.equalsIgnoreCase("female")){
            gender= driver.findElement(By.xpath("//span[contains(.,'Female')]"));
        }
        return gender;
    }
    public boolean accountCreated(String name){
        try {
            return driver.findElement(By.xpath("//h2[contains(.,'" + name + "') and contains(.,'Your account has been created!')]")).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
    public WebElement getStarted(){
        By myName=By.xpath("//button[contains(.,'Get started')]");
        return driver.findElement(myName);
    }



}
