package com.columbia.pages;

import com.columbia.utilities.BrowserUtils;
import com.columbia.utilities.ConfigurationReader;
import com.columbia.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(css = "#title") public WebElement adresBasligi_Loc;

    @FindBy(css = "#countryId") public WebElement ulke_Loc;

    @FindBy(css = "#cityId") public WebElement sehir_Loc;

    @FindBy(css = "#countyId") public WebElement ilce_Loc;

    @FindBy(xpath = "//*[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button']") public List<WebElement> dataList_Loc;

    @FindBy(css = "#zipPostalCode") public WebElement postaKodu_Loc;

    @FindBy(css = "#streetAddress") public WebElement adres_Loc;

    @FindBy(css = "#storeId") public WebElement magaza_Loc;

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

    public void enterGuestAdress(){
        BrowserUtils.scrollDown();
        BrowserUtils.waitFor(1);
        adresBasligi_Loc.sendKeys("Isyeri");
        ad_Loc.sendKeys("Test");
        soyad_Loc.sendKeys("Test");
        email_Loc.sendKeys(ConfigurationReader.get("guest_email"));
        telefon_Loc.click();
        telefon_Loc.sendKeys("075555555");
        BrowserUtils.waitFor(2);

        new Actions(Driver.get()).moveToElement(ulke_Loc).doubleClick(ulke_Loc).perform();

        BrowserUtils.waitFor(1);

        sehir_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allCity = dataList_Loc;

        for (int i = 0; i < allCity.size(); i++) {
            if (allCity.get(i).getText().contains("Ankara")){
                allCity.get(i).click();
                break;
            }
        }

        BrowserUtils.waitFor(1);

        ilce_Loc.click();
        BrowserUtils.waitFor(1);

        List<WebElement> allCounty= dataList_Loc;

        for (int i = 0; i < allCounty.size(); i++) {
            if (allCounty.get(i).getText().contains("EVREN")){
                allCounty.get(i).click();
                break;
            }
        }
        BrowserUtils.waitFor(1);
        postaKodu_Loc.sendKeys("34340");
        BrowserUtils.waitFor(1);
        adres_Loc.sendKeys("test test test");
        BrowserUtils.waitFor(1);
    }

    public void storeInformations(){
        sehir_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allCity = dataList_Loc;

        for (int i = 0; i < allCity.size(); i++) {
            if (allCity.get(i).getText().contains("Bursa")){
                allCity.get(i).click();
                break;
            }
        }

        magaza_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allStore = dataList_Loc;

        for (int i = 0; i < allStore.size(); i++) {
            if (allStore.get(i).getText().contains("Marka AVM")){
                allStore.get(i).click();
                break;
            }
        }
        BrowserUtils.waitFor(1);

        ad_Loc.sendKeys("Test");
        soyad_Loc.sendKeys("Test");
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        telefon_Loc.sendKeys("05555555555");
        BrowserUtils.waitFor(1);
    }

    public void invalidCard(){
        kartNo_Loc.sendKeys("4444444444444444");
        adSoyad_Loc.sendKeys("Test Test");

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

    public void clickSepetimButton(){
        BrowserUtils.waitForClickablility(sepetim_Loc,5);
        sepetim_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void checkBox(){
        threeD_Loc.click();
        mesafeliSatis_Loc.click();
        onBilgilendirme_Loc.click();
        BrowserUtils.waitFor(1);
    }
}
