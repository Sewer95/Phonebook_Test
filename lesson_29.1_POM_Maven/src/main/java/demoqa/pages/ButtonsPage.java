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
    verifyMessage(doubleClickMessage,text);
    return this;
  }
  @FindBy(id = "rightClickBtn")
  WebElement rightClickBtn;

  public ButtonsPage rightClickButton() {
    new Actions(driver).contextClick(rightClickBtn).perform();
    return this;
  }

  @FindBy(id = "rightClickMessage")
  WebElement rightClickMessage;

  public ButtonsPage verifyRightClickMessage(String text) {
    assert rightClickMessage.getText().equals(text);
    return this;
  }


  @FindBy(xpath = "//button[text()='Click Me']")
  WebElement clickMeButton;

  public ButtonsPage clickButton() {
    click(clickMeButton);
    return this;
  }


  @FindBy(id = "dynamicClickMessage")
  WebElement dynamicClickMessage;

  public ButtonsPage verifyDynamicClickMessage(String text) {
    assert dynamicClickMessage.getText().equals(text);
    return this;
  }


}
