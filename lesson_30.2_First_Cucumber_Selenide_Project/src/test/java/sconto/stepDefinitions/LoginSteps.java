package sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sconto.pages.CustomerAccountPage;
import sconto.pages.HomePage;
import sconto.pages.LoginPage;

public class LoginSteps {
    HomePage home;
    LoginPage login;
    CustomerAccountPage customer;

    @When("User clicks on Login icon")
    public void userClicksOnLoginIcon() {
        home = Selenide.page(HomePage.class);
        login = home.clickOnLoginIcon();
    }

    @Then("User is verifies Login form")
    public void userIsVerifiesLoginForm() {
        login.verifyFormTitle();

    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        login.validLoginInput();
    }

    @And("User clicks on Anmelden button")
    public LoginPage userClicksOnAnmeldenButton() {
        login.clickOnAnmeldenButton();
        return Selenide.page(LoginPage.class);
    }

    @Then("User verifies User Name status")
    public void userVerifiesUserNameStatus() {
        home.userNameStatus();
    }


    @Then("User verifies User Name")
    public void userVerifiesUserName() {
        customer = Selenide.page(CustomerAccountPage.class);
        customer.verifyUserName("Serhii Shvets");
    }
}
