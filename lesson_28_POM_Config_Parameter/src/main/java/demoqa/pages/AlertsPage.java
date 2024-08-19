package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlertsPage extends BasePage {

  public AlertsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "timerAlertButton")
  WebElement timerAlertButton;

  public AlertsPage clickAlertWithTimer() {
    click(timerAlertButton);
    new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).accept();
    return this;
  }

  @FindBy(id = "confirmButton")
  WebElement confirmButton;

  public AlertsPage clickOnConfirmButton() {
    click(confirmButton);
    return this;
  }

  public AlertsPage selectResult(String confirm) {
    if (confirm != null && confirm.equals("OK")) {
      driver.switchTo().alert().accept();
    } else if (confirm != null && confirm.equals("Cancel")) {
      driver.switchTo().alert().dismiss();
    }
    return this;
  }

  @FindBy(id = "confirmResult")
  WebElement confirmResult;

  public AlertsPage verifyResult(String result) {
    shouldHaveText(confirmResult, result, 5000);
    return this;
  }

  @FindBy(id = "promtButton")
  WebElement promtButton;

  public AlertsPage sendMessageToAlert(String text) {
    click(promtButton);
    driver.switchTo().alert().sendKeys(text);
    driver.switchTo().alert().accept();
    return this;
  }

  @FindBy(id = "promptResult")
  WebElement promptResult;

  public AlertsPage verifyMessage(String textToFind) {
    assert promptResult.getText().contains(textToFind);
    return this;
  }


  @FindBy(tagName ="iframe")
  List<WebElement> iframes;
  public AlertsPage getListOfFrames() {
    //System.out.println(iframes.size());
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
    System.out.println("Numbers of iFrames on the page is: " + numberOfIframes);
    for (WebElement iframe : iframes){
      System.out.println(iframe.getAttribute("id"));
    }
    return this;
  }

  public AlertsPage switchToIframeByIndex(int index) {
    driver.switchTo().frame(index);
    return this;
  }

  @FindBy(id = "sampleHeading")
  WebElement sampleHeading;


  public AlertsPage verifyIframeText(String text) {
    shouldHaveText(sampleHeading, text, 5000);
    return this;
  }

  public AlertsPage switchToIframeByName(String name) {
    driver.switchTo().frame(name);
    return this;
  }

  @FindBy(id = "frame1")
  WebElement frame1;

  public AlertsPage switchToIframeById() {
    driver.switchTo().frame(frame1);
    return this;
  }

  public AlertsPage returnToMainContent() {
    driver.switchTo().defaultContent();
    return this;
  }


  @FindBy(css = "div#framesWrapper")
  WebElement mainContent;

  public AlertsPage verifyMainContentText(String textToFind) {
    //shouldHaveText(mainContent, textToFind, 500);
    assert mainContent.getText().contains(textToFind);
    return this;
  }
}
