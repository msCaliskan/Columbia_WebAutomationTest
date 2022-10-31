package com.columbia.pages;

import com.columbia.utilities.BrowserUtils;
import com.columbia.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    public static void verifyUrl(String expectedURL) {
        String actualTitle = Driver.get().getCurrentUrl();
        actualTitle = actualTitle.replace("https://www.columbia.com.tr","");
        Assert.assertEquals(expectedURL,actualTitle);
    }

    public static String verifyMessage(String msg){
        BrowserUtils.waitFor(2);
        String msg_Loc = Driver.get().findElement(By.xpath("//*[text()='"+msg+"']")).getText();

        return msg_Loc;
    }

    public static void clickButton(String button){
    String button_Loc = "//*[text()='"+button+"']";
    BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(button_Loc)),5);
    Driver.get().findElement(By.xpath(button_Loc)).click();
    BrowserUtils.waitFor(2);
    }

    public static void clickButtonn(String button){
        String button_Loc = "(//*[text()='"+button+"'])[2]";
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(button_Loc)),5);
        Driver.get().findElement(By.xpath(button_Loc)).click();
        BrowserUtils.waitFor(2);
    }

    /**
     * This method will navigate user to the specific module in useinsider application.
     * For example: if tab is equals to More, and module equals to Careers,
     * Then method will navigate user to this page: https://useinsider.com/careers/
     *
     * @param tab
     * @param module
     * @param subModule
     *
     */
    public static void navigateToModule(String tab, String module, String subModule) {
        String tabLocator = "//a[text()='"+tab+"']";
        String moduleLocator = "//h6[text()='"+module+"']";
        String subModuleLocator ="//h6[text()='"+subModule+"']";

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
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(subModuleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(subModuleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(subModuleLocator)));
            Driver.get().findElement(By.xpath(subModuleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(subModuleLocator)),  5);

        }
    }

}
