package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

  public BrowserWindowsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "tabButton")
  WebElement tabButton;

  public BrowserWindowsPage switchToNextTab(int index) {
    click(tabButton);
    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(index));
    return this;
  }

  @FindBy(id = "sampleHeading")
  WebElement sampleHeading;

  public BrowserWindowsPage verifyTabTitle(String text) {
    shouldHaveText(sampleHeading, text, 5000);
    return this;
  }
}
