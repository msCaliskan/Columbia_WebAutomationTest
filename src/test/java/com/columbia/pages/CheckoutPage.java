package com.columbia.pages;

import com.columbia.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//*[@*='cardnumber']") public WebElement kartNo_Loc;

    @FindBy(xpath = "//*[@*='ccname']") public WebElement adSoyad_Loc;

    @FindBy(xpath = "(//*[@id='standard-select-currency-native'])[1]") public WebElement sktAy_Loc;

    @FindBy(xpath = "//*[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button']") public List<WebElement> ayList_Loc;

    @FindBy(xpath = "(//*[@id='standard-select-currency-native'])[2]") public WebElement sktYil_Loc;

    @FindBy(xpath = "//*[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button']") public List<WebElement> yilList_Loc;

    @FindBy(xpath = "//*[@*='cvc']") public WebElement cvc_Loc;

    @FindBy(xpath = "(//*[@*='checkbox'])[1]") public WebElement threeD_Loc;

    @FindBy(xpath = "(//*[@*='checkbox'])[2]") public WebElement mesafeliSatis_Loc;

    @FindBy(xpath = "(//*[@*='checkbox'])[3]") public WebElement onBilgilendirme_Loc;

    @FindBy(css = "#setAnchorButton") public WebElement sepetim_Loc;

    public void invalidCard(){
        kartNo_Loc.sendKeys("4444444444444444");
        adSoyad_Loc.sendKeys("Musa Çalışkan");

        BrowserUtils.waitFor(1);

        sktAy_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allMonths = ayList_Loc;

        for (int i = 1; i <= allMonths.size(); i++) {
            if (allMonths.get(i).getText().contains("10")){
                allMonths.get(i).click();
                break;
            }
        }
        BrowserUtils.waitFor(1);

        sktYil_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allYear = yilList_Loc;

        for (int i = 1; i <= allYear.size(); i++) {
            if (allYear.get(i).getText().contains("2030")){
                allYear.get(i).click();
                break;
            }
        }

        cvc_Loc.sendKeys("295");
        BrowserUtils.waitFor(2);
    }
    public void checkBox(){
        threeD_Loc.click();
        mesafeliSatis_Loc.click();
        onBilgilendirme_Loc.click();
        BrowserUtils.waitFor(1);
    }
}
