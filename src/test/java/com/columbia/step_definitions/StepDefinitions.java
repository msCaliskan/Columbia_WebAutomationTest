package com.columbia.step_definitions;

import com.columbia.pages.*;
import com.columbia.utilities.BrowserUtils;
import com.columbia.utilities.ConfigurationReader;
import com.columbia.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class StepDefinitions {

    AccountPage accountPage = new AccountPage();
    HomePage homePage = new HomePage();
    CategoryAndProductPage categoryAndProductPage = new CategoryAndProductPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("The user visits Columbia homepage")
    public void the_user_visits_Columbia_homepage() {
        homePage.gotoHomePage();
        BrowserUtils.waitFor(1);
    }

    @And("The user verifies redirected to homepage")
    public void the_user_verifies_redirected_to_homepage() {
        HomePage.checkHomePage();
    }

    @Given("The user hovers to login button")
    public void the_user_hovers_to_login_button() {
        BrowserUtils.hover(homePage.loginBtn_Loc);
    }

    @Given("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        homePage.login();
    }

    @When("The user clicks login button")
    public void the_user_clicks_login_button() {
        homePage.clickLogin();
    }

    @Given("The user clicks hamburger menu button")
    public void the_user_clicks_hamburger_menu_button() {
        BrowserUtils.waitFor(2);
        homePage.hamburgerMenuBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    @When("The user verifies redirected to {string} page")
    public void the_user_verifies_redirected_to_page(String expUrl) {
        BasePage.verifyUrl(expUrl);
    }

    @When("The user checks {string}, {string}, {string} and {string} informations")
    public void the_user_checks_and_informations(String name, String lastName, String email, String phone) {
        accountPage.getInformation(name,lastName,email,phone);
    }
    @When("The user clicks arrow button")
    public void the_user_clicks_arrow_button() {
        accountPage.arrowBtn_Loc.click();
    }

    @When("The user clicks {string} button")
    public void the_user_clicks_button(String button) {
        BasePage.clickButton(button);
    }

    @When("The user enters old, new and confirm new password")
    public void the_user_enters_old_new_and_confirm_new_password() {
        accountPage.changePassword();
    }

    @When("The user enters valid informations")
    public void the_user_enters_valid_informations() {
      accountPage.enterAdress();
    }

    @When("The user enters valid informations for guest")
    public void theUserEntersValidInformationsForGuest() {
        accountPage.enterGuestAdress();
    }

    @Given("The user navigates to {string} {string} {string} category")
    public void the_user_navigates_to_category(String tab, String module, String subModule) {
        BasePage.navigateToModule(tab,module,subModule);
    }

    @When("The user clicks anyone product")
    public void the_user_clicks_anyone_product() {
        categoryAndProductPage.clickProductRandom();
    }

    @When("The user clicks hearth button")
    public void the_user_clicks_hearth_button() {
        categoryAndProductPage.hearthBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    @When("The user verifies {string} message")
    public void the_user_verifies_message(String message) {
        Assert.assertEquals(message, BasePage.verifyMessage(message));
    }

    @When("The user chooses color and size")
    public void the_user_chooses_color_and_size() {
        categoryAndProductPage.selectSize();
    }

    @When("The user enters invalid informations")
    public void the_user_enters_invalid_informations() {
        checkoutPage.invalidCard();
    }

    @When("The user selects 3D Secure, On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons")
    public void the_user_selects_3D_Secure_On_Bilgilendirme_and_Mesafeli_Satis_Sozlesmesi_buttons() {
        checkoutPage.checkBox();
    }

    @Then("The user clicks Back button")
    public void the_user_clicks_Back_button() {
        Driver.get().navigate().back();
    }


    @Then("The user enters forget password email adress")
    public void the_user_enters_forget_password_email_adress() {
        homePage.email_Loc.sendKeys(ConfigurationReader.get("user_email"));
    }
    @Given("The user fills {string} in the searchbox and click")
    public void the_user_fills_in_the_searchbox_and_click(String string) {
        homePage.searchBox(string);
    }

    @Then("The user should see all search results match with {string}")
    public void the_user_should_see_all_search_results_match_with(String string) {
        categoryAndProductPage.searchResult(string);
    }

    @Then("The user clicks Şifremi Sıfırla button")
    public void theUserClicksŞifremiSıfırlaButton() {
        accountPage.sifremiSifirla_Loc.click();
    }

    @And("The user closes pop-Ups")
    public void theUserClosesPopUps() {
        homePage.closePopUp();
    }

    @And("The user closes arrows")
    public void theUserClosesArrows() {
        accountPage.closeArrow();
    }

    @And("The user clicks Ödeme Adımına Geç button")
    public void theUserClicksÖdemeAdımınaGeçButton() {
        accountPage.odemeAdimiBtn();
    }

    @Then("The user clicks Sepetim button")
    public void theUserClicksSepetimButton() {
        checkoutPage.sepetim_Loc.click();
        BrowserUtils.waitFor(1);
    }

    @And("The user verifies message")
    public void theUserVerifiesMessage() {
        AccountPage.verifyMessage();
    }

    @And("The user clicks Çıkış button")
    public void theUserClicksÇıkışButton() {
        BrowserUtils.clickWithJS(accountPage.cikisYap_Loc);
    }

    @And("The user enters invalid email")
    public void theUserEntersInvalidEmail() {
        homePage.invalidEmailCheck();
    }

    @And("The user enters invalid password")
    public void theUserEntersInvalidPassword() {
        homePage.invalidPasswordCheck();
    }

    @And("The user chooses store informations")
    public void theUserChoosesStoreInformations() {
        accountPage.storeInformations();
    }

    @And("The user enters wrong old password")
    public void theUserEntersWrongOldPassword() {
        accountPage.wrongOldPassword();
    }

    @And("The user enters different passwords")
    public void theUserEntersDifferentPasswords() {
        accountPage.differentPassword();
    }

    @And("The user enters valid price")
    public void theUserEntersValidPrice() {
        categoryAndProductPage.validPrice();
    }

}
