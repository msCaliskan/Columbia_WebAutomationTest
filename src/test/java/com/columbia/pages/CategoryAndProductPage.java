package com.columbia.pages;

import com.columbia.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class CategoryAndProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-4 MuiGrid-grid-md-3')]") public List<WebElement> prodList_Loc;

    @FindBy(xpath = "//button[contains(@class, 'MuiLink-button MuiTypography-caption MuiTypography-colorPrimary')]") public List<WebElement> sizeList_Loc;

    @FindBy(xpath = "//div[contains(@class,'MuiButton-disableElevation')]") public WebElement hearthBtn_Loc;

    @FindBy(xpath = "//*[contains(@class,'MuiTypography-button')]") public WebElement sepeteEkle_Loc;

    @FindBy(css = "#filled-number") public WebElement priceHolder_Loc;

    @FindBy(xpath = "//*[text()='Tekrar Gösterme']") public WebElement popUp_Loc;

    public void clickProductRandom(){

        Random rn = new Random();
        int a = rn.nextInt(prodList_Loc.size());


        BrowserUtils.waitFor(1);
        BrowserUtils.hover(prodList_Loc.get(a));
        BrowserUtils.waitFor(1);
        prodList_Loc.get(a).click();
        BrowserUtils.waitFor(1);
    }

    public void selectSize(){

        for (int i = 0; i < sizeList_Loc.size(); i++) {
            sizeList_Loc.get(i).click();
            BrowserUtils.waitFor(1);

            if (sepeteEkle_Loc.getText().equalsIgnoreCase("Sepete Ekle")) {
                    sepeteEkle_Loc.click();
                    break;
                }
        }
    }

    public void clickHearthButton(){
        BrowserUtils.waitForClickablility(hearthBtn_Loc,5);
        hearthBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void searchResult(String string){

        for (int i = 0; i < prodList_Loc.size(); i++) {
            Assert.assertTrue("Search result value failed at instance [" + i + "]." ,prodList_Loc.get(i).getText().contains(string));

        }
    }
    public void validPrice(){
        String price = priceHolder_Loc.getAttribute("value");

        double b = Double.parseDouble(price);
        int c= (int)Math.round(b);

        int d = c-5;

        priceHolder_Loc.sendKeys(Keys.CONTROL+"a");
        priceHolder_Loc.sendKeys(Keys.DELETE);
        BrowserUtils.waitFor(1);
        priceHolder_Loc.sendKeys(Integer.toString(d));
        BrowserUtils.waitFor(2);
    }

    public void closePopUp(){
        BrowserUtils.waitFor(5);
        try {
            BrowserUtils.waitForClickablility(popUp_Loc,3);
            popUp_Loc.click();
            BrowserUtils.waitFor(1);
        }catch (Exception e){
            BrowserUtils.waitFor(1);
        }
    }
}