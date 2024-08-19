package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends BookStorePage {
  public ToolTipsPage(WebDriver driver) {
    super(driver);
  }


  @FindBy(xpath = "//a[.='Contrary']")
  WebElement contrary;

  public ToolTipsPage hoverToolTip() {
    pause(500);
    new Actions(driver).moveToElement(contrary).perform();
    pause(500); // Задержаться чтобы всплыл туллтип
    return this;
  }

  @FindBy(className = "tooltip-inner")
  WebElement toolTip;

  public ToolTipsPage verifyToolTipText(String text) {
    assert toolTip.getText().equals(text);
    return this;
  }
}
