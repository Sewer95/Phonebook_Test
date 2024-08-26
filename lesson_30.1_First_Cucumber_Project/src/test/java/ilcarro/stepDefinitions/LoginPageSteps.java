package ilcarro.stepDefinitions;

import ilcarro.pages.HomePage;
import ilcarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static ilcarro.core.BasePage.driver;

public class LoginPageSteps {
    @And("Пользователь нажимает на ссылку Log in")
    public void userClicksOnLogInLink() {
        new HomePage(driver).clickOnLogInLink();

    }

    @And("Пользователь вводит валидные данные")
    public void userEnterValidCredentials() {
        new LoginPage(driver).enterCredentials("shvets1.serhii@gmail.com", "Qwertz@1");
    }

    @And("Пользователь нажимает на кнопку Yalla")
    public void userClickedOnYallaButton() {
        new LoginPage(driver).clickOnYallaButton();
    }

    @Then("Пользователь проверяет отображение сообщения об успешном логине")
    public void userVerifySuccessLoginMessage() {
        new LoginPage(driver).verifyTextMessage("Logged in success");
    }

    @And("Пользователь вводит валидный email и невалидный пароль")
    public void userEntersValidEmailAndInvalidPassword(DataTable table) {
        new LoginPage(driver).enterInValidCredentials(table);
    }

    @Then("Пользователь проверяет отображение сообщения от неуспешном логине")
    public void userChecksErrorMessage() {
        new LoginPage(driver).verifyTextMessage("\"Login or Password incorrect\"");
    }
}
