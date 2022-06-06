package com.columbia.pages;


import com.columbia.utilities.BrowserUtils;
import com.columbia.utilities.ConfigurationReader;
import com.columbia.utilities.Driver;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.*;

public class AccountPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(css = "#oldPassword") public WebElement gecerliSifre_Loc;

    @FindBy(css = "#newPassword") public WebElement yeniSifre_Loc;

    @FindBy(css = "#confirmNewPassword") public WebElement sifreTekrari_Loc;

    @FindBy(xpath = "//span[text()='Şifre Değiştir']") public WebElement sifreDegistirBtn_Loc;

    @FindBy(css = "#title") public WebElement adresBasligi_Loc;

    @FindBy(css = "#countryId") public WebElement ulke_Loc;

    @FindBy(css = "#cityId") public WebElement sehir_Loc;

    @FindBy(css = "#countyId") public WebElement ilce_Loc;

    @FindBy(xpath = "//*[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button']") public List<WebElement> dataList_Loc;

    @FindBy(css = "#storeId") public WebElement magaza_Loc;

    @FindBy(css = "#zipPostalCode") public WebElement postaKodu_Loc;

    @FindBy(css = "#streetAddress") public WebElement adres_Loc;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root'])[2]") public WebElement arrowBtn_Loc;

    @FindBy(xpath = "(//*[text()='Şifremi Sıfırla'])[2]") public WebElement sifremiSifirla_Loc;

    @FindBy(xpath = "//*[contains(@class, 'ins-side-menu-arrow ins')]") public WebElement popUpArrow_Loc;

    @FindBy(xpath = "(//*[text()='Ödeme Adımına Geç'])[2]") public WebElement odemeAdiminaGec_Loc;

    @FindBy(xpath = "//*[text()='Çıkış']") public WebElement cikisYap_Loc;

    public void getInformation(String name, String lastname, String email, String phone){
        String actName = ad_Loc.getAttribute("value");
        String actlastName = soyad_Loc.getAttribute("value");
        String actEmail = email_Loc.getAttribute("value");
        String actPhone = telefon_Loc.getAttribute("value");

        assertEquals(name,actName);
        assertEquals(lastname,actlastName);
        assertEquals(email,actEmail);
        assertEquals(phone,actPhone);
    }

    public void changePassword(){
        gecerliSifre_Loc.sendKeys("Inveon34.");
        yeniSifre_Loc.sendKeys("Inveon34.");
        sifreTekrari_Loc.sendKeys("Inveon34.");

        sifreDegistirBtn_Loc.click();
        BrowserUtils.waitFor(2);
    }

    public void wrongOldPassword(){
        gecerliSifre_Loc.sendKeys("Inveon34..");
        yeniSifre_Loc.sendKeys("Inveon34.");
        sifreTekrari_Loc.sendKeys("Inveon34.");

        sifreDegistirBtn_Loc.click();
        BrowserUtils.waitFor(2);
    }
    public void differentPassword(){
        gecerliSifre_Loc.sendKeys("Inveon34.");
        yeniSifre_Loc.sendKeys("Inveon34..");
        sifreTekrari_Loc.sendKeys("Inveon34.");

        sifreDegistirBtn_Loc.click();
        BrowserUtils.waitFor(2);
    }

    public void enterAdress(){
        BrowserUtils.waitFor(1);
        adresBasligi_Loc.sendKeys("Isyeri");
        ad_Loc.sendKeys("Musa");
        soyad_Loc.sendKeys("Caliskan");
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        telefon_Loc.click();
        telefon_Loc.sendKeys("075002920");
        BrowserUtils.waitFor(2);

        new Actions(Driver.get()).moveToElement(ulke_Loc).doubleClick(ulke_Loc).perform();

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
        adres_Loc.sendKeys("Levent, HAN Spaces, Nispetiye Cd No:24");
        BrowserUtils.waitFor(1);
    }
    public void enterGuestAdress(){
        BrowserUtils.scrollDown();
        BrowserUtils.waitFor(1);
        adresBasligi_Loc.sendKeys("Isyeri");
        ad_Loc.sendKeys("Musa");
        soyad_Loc.sendKeys("Caliskan");
        email_Loc.sendKeys(ConfigurationReader.get("guest_email"));
        telefon_Loc.click();
        telefon_Loc.sendKeys("075002920");
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
        adres_Loc.sendKeys("Levent, HAN Spaces, Nispetiye Cd No:24");
        BrowserUtils.waitFor(1);
    }

    public void closeArrow(){
        if (popUpArrow_Loc.getAttribute("class").contains("opened")){
            popUpArrow_Loc.click();
        }
    }

    public void odemeAdimiBtn(){
        BrowserUtils.waitForClickablility(odemeAdiminaGec_Loc,5);
        odemeAdiminaGec_Loc.click();
    }

    public static void verifyMessage(){
        String actual = Driver.get().findElement(By.xpath("//*[text()='Sepetiniz Boş']")).getText();
        String expected = "SEPETINIZ BOŞ";

        Assert.assertEquals(expected,actual);
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

        ad_Loc.sendKeys("Musa");
        soyad_Loc.sendKeys("Caliskan");
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        telefon_Loc.sendKeys("05075002920");
        BrowserUtils.waitFor(1);

    }
}
