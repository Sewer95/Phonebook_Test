package ilcarro.stepDefinitions;

import ilcarro.pages.HomePage;
import ilcarro.pages.LetTheCarWorkPage;
import ilcarro.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.awt.*;

import static ilcarro.core.BasePage.driver;

public class LetTheCarWorkSteps {

    @And("Пользователь нажимает на ссылку Let the car work")
    public void userClicksOnLetTheCarWorkLink() {
        new HomePage(driver).clickOnLetTheCarWorkLink();

    }

    @And("Пользователь вводит локацию Haifa, Israel")
    public void userEnterLocation() throws AWTException {
        new LetTheCarWorkPage(driver).enterLocation()
        ;
    }

    @And("Пользователь вводит данные автомобиля и добавляет фото")
    public void userAddedCarsData() {
        new LetTheCarWorkPage(driver).enterCarData();
    }

    @And("Пользователь нажимает на кнопку Submit")
    public void userClickedSubmitButton() {
        new LetTheCarWorkPage(driver).clickOnSubmitButton();
    }

    @Then("Пользователь проверяет отображение сообщения об успешном добавлении авто")
    public void verifySuccessMessage() {
        new LetTheCarWorkPage(driver).verifySuccessMessage("Car added");
    }
}
