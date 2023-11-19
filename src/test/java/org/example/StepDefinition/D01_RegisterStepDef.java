package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Pages.P01_RegisterPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.StepDefinition.Hooks.driver;

public class D01_RegisterStepDef{

    P01_RegisterPage register=new P01_RegisterPage();

    @And("Open {string}")
    public void user_navigate_to_home_page(String url)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get(url);
    }
    @And("user close Ad and click on Account then SignIn")
    public void user_click_Account_SignIn(){
//        register.click(register.closeAdButton());
        register.click(register.accountButton());
        register.click(register.signIn());
    }
    @And("user enter valid email{string} then click Continue")
    public void user_Enter_Valid_Email_Click_Continue(String email){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions actions=new Actions(driver);
        actions.moveToElement(register.emailField()).sendKeys(email).perform();
//        register.sendKeys(register.emailField(),email);
        register.click(register.continueButton());
    }
    @Then("validate the email{string} and create password{string}")
    public void validateEmailAndCreatePassword(String email,String password){
        SoftAssert softAssert=new SoftAssert();
        String actual=register.getText(register.emailLabel());
        softAssert.assertTrue(actual.contains(email),"The actual Email is: "+actual);
        register.clear(register.passwordField());
        register.sendKeys(register.passwordField(),password);
        register.clear(register.confirmPasswordField());
        register.sendKeys(register.confirmPasswordField(),password);
        Actions actions=new Actions(driver);
        register.waitToBeClickable(register.continueButtonTwo(),10);
        actions.moveToElement(register.continueButtonTwo()).build().perform();
        actions.moveToElement(register.continueButtonTwo()).click(register.continueButtonTwo()).perform();
    }
    @And("Enter firstname{string} and lastname{string} and mobileNumber{string} then click continue")
    public void enterFNameLName_mobileNumber_Continue(String fName,String lName,String phone){
        register.sendKeys(register.firstName(),fName);
        register.sendKeys(register.lastName(),lName);
        register.sendKeys(register.phoneNumber(),phone);
        register.click(register.continueButtonThree());
    }
    @Then("Select the gender{string} and birthdate{string}{string}{string}")
    public void selectGender_birthdate(String gender,String day,String month,String year){
        register.click(register.gender());
        register.click(register.genderType(gender));
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(register.birthDate())).click(driver.findElement(register.birthDate())).perform();
        actions.moveToElement(driver.findElement(register.birthDate())).sendKeys(day+month+year).perform();

    }
    @And("check read the terms and click continue")
    public void checkTermsAnd_Continue(){
        register.click(register.acceptTC());
        register.click(register.continueLastButton());

    }
    @Then("validate account has been created with name{string}")
    public void validate_createdAccountSuccess(String name){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(register.accountCreated(name));
        softAssert.assertTrue(register.getStarted().isDisplayed());
        register.click(register.getStarted());

    }

}
