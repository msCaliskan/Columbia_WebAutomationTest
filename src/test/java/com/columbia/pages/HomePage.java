package com.columbia.pages;

import com.columbia.utilities.BrowserUtils;
import com.columbia.utilities.ConfigurationReader;
import com.columbia.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage{

    @FindBy(xpath = "//*[contains(@class, 'sp-fancybox-iframe')]") public WebElement iframe_Loc;

    @FindBy(xpath = "//*[@class='fa fa-times element-close-button']") public WebElement popUp2_Loc;

    @FindBy(xpath = "//span[text()='Kabul Ediyorum']") public WebElement cookies_Loc;

    @FindBy(xpath = "//*[@aria-label='close']") public WebElement cookies2_Loc;

    @FindBy(css = "#ins-frameless-overlay") public WebElement popUp_Loc;

    @FindBy(xpath = "//*[@data-testid='header-account-button']") public WebElement loginBtn_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#password") public WebElement password_Loc;

    @FindBy(css = "#search") public WebElement searchBox_Loc;

    @FindBy(css = "a[href='https://www.instagram.com/columbiasportswear_tr']") public WebElement instagramButton_Loc;

    @FindBy(css = "a[href='https://www.facebook.com/ColumbiaTurkey']") public WebElement facebookButton_Loc;

    @FindBy(css = "a[href='https://twitter.com/Columbia_TR']") public WebElement twitterButton_Loc;

    @FindBy(css = "a[href='https://www.youtube.com/channel/UCxKwjVULZxWFw1r6SZloXAw']") public WebElement youtubeButton_Loc;

    @FindBy(css = "a[href='https://tr.pinterest.com/columbia1938/']") public WebElement pinterestButton_Loc;

    @FindBy(css = "a[href='https://www.linkedin.com/company/columbia-sportswear/']") public WebElement linkedinButton_Loc;

    @FindBy(xpath = "//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineNone jss211 MuiTypography-colorSecondary']") public List<WebElement> footerLinks_Loc;



    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));

        BrowserUtils.waitFor(2);


        BrowserUtils.waitForClickablility(cookies2_Loc,5);
        cookies2_Loc.click();
        BrowserUtils.waitFor(1);
        cookies_Loc.click();
        BrowserUtils.waitFor(1);

    }

    public void clickLogin(){
        BrowserUtils.waitFor(1);
        loginBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void login(){
    String email = ConfigurationReader.get("user_email");
    String password = ConfigurationReader.get("user_password");

    email_Loc.sendKeys(email);
    password_Loc.sendKeys(password);
    }

    public static void checkHomePage(){
        String expectedTitle ="Columbia Türkiye Online Shop";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public static void navigateToCategory(String tab, String module) {
        String tabLocator = "//a[text()='" + tab + "']";
        String moduleLocator = "//*[text()='" + module + "']";

        try {
            BrowserUtils.waitFor(1);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            Actions actions = new Actions(Driver.get());
            actions.moveToElement(tabElement).perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);

        }
    }

    public void searchBox(String string){
        searchBox_Loc.sendKeys(string+ Keys.ENTER);

        BrowserUtils.waitFor(1);
    }
    public void closePopUp(){
        BrowserUtils.waitFor(1);
       try {
           Driver.get().switchTo().frame(iframe_Loc);
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

    public void closePopUp2(){
        try {
            BrowserUtils.waitFor(1);
            popUp_Loc.click();
        }catch (Exception e){
            BrowserUtils.waitFor(1);
        }
    }

    public void clickInstagramButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(instagramButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyInstagramPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Columbia Sportswear Turkey (@columbiasportswear_tr) • Instagram photos and videos";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickFacebookButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(facebookButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyFacebookPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Columbia Sportswear - Home | Facebook";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickTwitterButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(twitterButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyTwitterPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Columbia_TR (@Columbia_TR) / Twitter";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickYoutubeButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(youtubeButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyYoutubePage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Columbia Sportswear - YouTube";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickPinterestButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(pinterestButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyPinterestPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Columbia Sportswear (columbia1938) - Profile | Pinterest";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickLinkedinButton(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(linkedinButton_Loc);
        BrowserUtils.waitFor(2);
    }

    public void verifyLinkedinPage(){
        BrowserUtils.getWindowHandle();
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Columbia Sportswear Company | LinkedIn";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void checkPageTitle(String button, String title){
        for (int i = 0; i < footerLinks_Loc.size(); i++) {
            if (footerLinks_Loc.get(i).getText().contains(button)){
                BrowserUtils.clickWithJS(footerLinks_Loc.get(i));
                BrowserUtils.waitForPageToLoad(10);
                BrowserUtils.waitFor(2);
                Assert.assertTrue("Search result value failed at instance ["+Driver.get().getTitle()+"]" ,Driver.get().getTitle().contains(title));
                BrowserUtils.waitFor(2);
                break;
            }
        }
    }
}
