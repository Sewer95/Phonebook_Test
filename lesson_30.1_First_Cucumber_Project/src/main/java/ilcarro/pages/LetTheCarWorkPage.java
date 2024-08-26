package ilcarro.pages;

import ilcarro.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LetTheCarWorkPage extends BasePage {
    public LetTheCarWorkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "pickUpPlace")
    WebElement locationInput;

    public LetTheCarWorkPage enterLocation() throws AWTException {
        Robot robot = new Robot();
        click(locationInput);
        try {
            type(locationInput, "Haif");
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;

    }

    @FindBy(xpath = "//label[.='Manufacture*']")
    WebElement carManufacture;

    @FindBy(id = "model")
    WebElement carModel;

    @FindBy(xpath = "//label[.='Year *']")
    WebElement carYear;


    public LetTheCarWorkPage enterCarData() {
        pause(500);
        click(carManufacture);
        type(carManufacture, "Mazda");
        click(carModel);
        type(carModel, "6");
        click(carYear);
        type(carYear, "2018");

        return this;

    }

    @FindBy(xpath = "//button[.='Submit']")
    WebElement submitButton;

    public LetTheCarWorkPage clickOnSubmitButton() {
        click(submitButton);
        return this;
    }


    @FindBy(xpath = "//h1[contains(text(),'Car added')]")
    WebElement carAddedMessage;

    public LetTheCarWorkPage verifySuccessMessage(String textToCheck) {
        pause(1000);
        assert carAddedMessage.getText().equals(textToCheck);
        return this;

    }
}
