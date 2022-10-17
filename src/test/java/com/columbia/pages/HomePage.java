package com.columbia.pages;

import com.columbia.utilities.BrowserUtils;
import com.columbia.utilities.ConfigurationReader;
import com.columbia.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@aria-label='close']") public WebElement popUp2_Loc;

    @FindBy(xpath = "//span[text()='Kabul Ediyorum']") public WebElement cookies_Loc;

    @FindBy(xpath = "//*[@aria-label='close']") public WebElement cookies2_Loc;

    @FindBy(xpath = "//*[@data-testid='header-account-button']") public WebElement loginBtn_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#password") public WebElement password_Loc;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root'])[1]") public WebElement hamburgerMenuBtn_Loc;

    @FindBy(css = "#search") public WebElement searchBox_Loc;

    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));

        BrowserUtils.waitFor(2);


        BrowserUtils.waitForClickablility(cookies2_Loc,5);
        cookies2_Loc.click();
        BrowserUtils.waitFor(1);
        cookies_Loc.click();

    }

    public void clickLogin(){
        BrowserUtils.waitFor(2);
        loginBtn_Loc.click();
        BrowserUtils.waitFor(2);
    }

    public void login(){
    String email = ConfigurationReader.get("user_email");
    String password = ConfigurationReader.get("user_password");

    email_Loc.sendKeys(email);
    password_Loc.sendKeys(password);
    }

    public static void checkHomePage(){
        String expectedUrl ="https://www.columbia.com.tr/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    public void searchBox(String string){
        searchBox_Loc.sendKeys(string+ Keys.ENTER);

        BrowserUtils.waitFor(1);
    }
    public void closePopUp(){
        BrowserUtils.waitFor(1);
       try {
           popUp2_Loc.click();
       }catch (WebDriverException e){
           BrowserUtils.waitFor(1);
       }
    }

    public void invalidEmailCheck(){
        email_Loc.sendKeys(ConfigurationReader.get("guest_email"));
        password_Loc.sendKeys(ConfigurationReader.get("user_password"));
    }
    public void invalidPasswordCheck(){
       email_Loc.sendKeys(ConfigurationReader.get("user_email"));
       password_Loc.sendKeys("Inveon34...");
    }

}
