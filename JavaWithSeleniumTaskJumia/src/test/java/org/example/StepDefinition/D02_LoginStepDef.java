package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Pages.P01_RegisterPage;
import org.example.Pages.P02_LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.StepDefinition.Hooks.driver;

public class D02_LoginStepDef {
    P02_LoginPage login=new P02_LoginPage();
    P01_RegisterPage register=new P01_RegisterPage();
    @And("user enter valid email{string} and valid password{string}")
    public void validEmailAndPassword(String email,String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        login.sendKeys(register.emailField(),email);
        login.click(register.continueButton());
        login.sendKeys(login.passwordLoginButton(),password);
        login.click(login.loginButton());

    }

    @And("user hover on Supermarket and click on bakery")
    public void hoverSupermarketClickBakery(){
        Actions actions=new Actions(driver);
        actions.moveToElement(login.supermarket()).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(login.bakery()).click().perform();

    }
    @And("add two items to cart")
    public void addItemsToCart(){
        login.addToCart();
    }
    @Then("verify items are added and subtotal is calculated correctly")
    public void verifyItemsAddedAndSubtotalIsRight(){
        double expected=login.getExpectedItemsPrice();
        double actual =login.actualSubtotalPriceValue();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(expected,actual,"The expected is"+expected +
                "and the actual is:"+actual);
        System.out.println("The expected is"+expected +
                "and the actual is:"+actual);
    }

}
