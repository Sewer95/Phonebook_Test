package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonsPage doubleClick() {
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }


    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;
    public ButtonsPage verifyDoubleClickMessage(String text) {
        assert doubleClickMessage.getText().equals(text);
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;
    public ButtonsPage rightClick() {
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;
    public ButtonsPage verifyContextClickMessage(String text) {
        assert rightClickMessage.getText().equals(text);
        return this;
    }

    @FindBy(xpath = "//button[.='Click Me']")
    WebElement dynamicClickBtn;
    public ButtonsPage dynamicClick() {
        clickWithJs(dynamicClickBtn, 0, 100);
        return this;
    }

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;
    public ButtonsPage verifyDynamicClickMessage(String text) {
        assert dynamicClickMessage.getText().equals(text);
        return this;
    }
}
