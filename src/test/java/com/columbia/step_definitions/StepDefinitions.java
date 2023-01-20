package com.columbia.step_definitions;

import com.columbia.pages.*;
import com.columbia.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class StepDefinitions {

    AccountPage accountPage = new AccountPage();
    AddressPage addressPage = new AddressPage();
    CategoryAndProductPage categoryAndProductPage = new CategoryAndProductPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    HomePage homePage = new HomePage();

    @Given("The user visits Columbia homepage")
    public void the_user_visits_Columbia_homepage() {
        homePage.gotoHomePage();
    }

    @And("The user verifies redirected to homepage")
    public void the_user_verifies_redirected_to_homepage() {
        HomePage.checkHomePage();
    }

    @Given("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        homePage.login();
    }

    @When("The user clicks login button")
    public void the_user_clicks_login_button() {
        homePage.clickLogin();
    }

    @When("The user verifies redirected to {string} page")
    public void the_user_verifies_redirected_to_page(String expUrl) {
        BasePage.verifyUrl(expUrl);
    }

    @When("The user checks {string}, {string}, {string} and {string} informations")
    public void the_user_checks_and_informations(String name, String lastName, String email, String phone) {
        accountPage.getInformation(name,lastName,email,phone);
    }

    @When("The user clicks {string} button")
    public void the_user_clicks_button(String button) {
        BasePage.clickButton(button);
    }

    @When("The user enters old, new and confirm new password")
    public void the_user_enters_old_new_and_confirm_new_password() {
        changePasswordPage.changePassword();
    }

    @When("The user enters valid informations")
    public void the_user_enters_valid_informations() {
      addressPage.enterAdress();
    }

    @When("The user enters valid informations for guest")
    public void theUserEntersValidInformationsForGuest() {
        checkoutPage.enterGuestAdress();
    }

    @Given("The user navigates to {string} {string} {string} category")
    public void the_user_navigates_to_category(String tab, String module, String subModule) {
        BasePage.navigateToModule(tab,module,subModule);
    }

    @When("The user clicks any product")
    public void the_user_clicks_any_product() {
        categoryAndProductPage.clickProductRandom();
    }

    @When("The user clicks hearth button")
    public void the_user_clicks_hearth_button() {
        categoryAndProductPage.clickHearthButton();
    }

    @When("The user verifies {string} message")
    public void the_user_verifies_message(String message) {
        Assert.assertEquals(message, BasePage.verifyMessage(message));
    }

    @When("The user chooses size")
    public void the_user_chooses_size() {
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

    @And("The user closes pop-Ups")
    public void theUserClosesPopUps() {
        homePage.closePopUp();
    }

    @Then("The user clicks Sepetim button")
    public void theUserClicksSepetimButton() {
        checkoutPage.clickSepetimButton();
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
        checkoutPage.storeInformations();
    }

    @And("The user enters wrong old password")
    public void theUserEntersWrongOldPassword() {
        changePasswordPage.wrongOldPassword();
    }

    @And("The user enters different passwords")
    public void theUserEntersDifferentPasswords() {
        changePasswordPage.differentPassword();
    }

    @And("The user enters valid price")
    public void theUserEntersValidPrice() {
        categoryAndProductPage.validPrice();
    }

    @And("The user clicks {string} buttonn")
    public void theUserClicksButtonn(String button) {
        BasePage.clickButtonn(button);
    }

    @And("The user navigates to {string} {string} category")
    public void theUserNavigatesToCategory(String category, String module) {
        HomePage.navigateToCategory(category,module);
    }

    @And("The user closes popUp")
    public void theUserClosesPopUp() {
        homePage.closePopUp2();
    }

    @And("The user closes popUpss")
    public void theUserClosesPopUpss() {
        categoryAndProductPage.closePopUp();
    }

    @And("The user clicks Instagram button")
    public void theUserClicksInstagramButton() {
        homePage.clickInstagramButton();
    }

    @And("The user verifies redirected to Instagram page")
    public void theUserVerifiesRedirectedToInstagramPage() {
        homePage.verifyInstagramPage();
    }

    @And("The user clicks Facebook button")
    public void theUserClicksFacebookButton() {
        homePage.clickFacebookButton();
    }

    @And("The user verifies redirected to Facebook page")
    public void theUserVerifiesRedirectedToFacebookPage() {
        homePage.verifyFacebookPage();
    }

    @And("The user clicks Twitter button")
    public void theUserClicksTwitterButton() {
        homePage.clickTwitterButton();
    }

    @And("The user verifies redirected to Twitter page")
    public void theUserVerifiesRedirectedToTwitterPage() {
        homePage.verifyTwitterPage();
    }

    @And("The user clicks Youtube button")
    public void theUserClicksYoutubeButton() {
        homePage.clickYoutubeButton();

    }

    @And("The user verifies redirected to Youtube page")
    public void theUserVerifiesRedirectedToYoutubePage() {
        homePage.verifyYoutubePage();
    }

    @And("The user clicks Pinterest button")
    public void theUserClicksPinterestButton() {
        homePage.clickPinterestButton();
    }

    @And("The user verifies redirected to Pinterest page")
    public void theUserVerifiesRedirectedToPinterestPage() {
        homePage.verifyPinterestPage();
    }

    @And("The user clicks Linkedin button")
    public void theUserClicksLinkedinButton() {
        homePage.clickLinkedinButton();
    }

    @And("The user verifies redirected to Linkedin page")
    public void theUserVerifiesRedirectedToLinkedinPage() {
        homePage.verifyLinkedinPage();
    }

    @And("The user clicks {string} and verifies {string}")
    public void theUserClicksAndVerifies(String button, String title) {
        homePage.checkPageTitle(button,title);
    }

}
