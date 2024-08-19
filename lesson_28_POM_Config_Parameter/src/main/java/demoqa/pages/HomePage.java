package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = ".top-card:nth-child(6)")
  WebElement bookStore;

  public SidePage getBookStore() {
    //scrollPage(200);
    //click(bookStore);
    //clickWithJs(bookStore, 0, 500);
    //clickWithScroll(bookStore, 200);
    moveToView(bookStore);
    click(bookStore);
    return new SidePage(driver);
  }

  @FindBy(css = ".top-card:nth-child(3)")
  WebElement alertsFrameWindows;

  public SidePage getAlertsFrameWindows() {
    click(alertsFrameWindows);
    return new SidePage(driver);
  }


  @FindBy(css = ".top-card:nth-child(4)")
  WebElement widgets;

  public SidePage getWidgets() {
    click(widgets);
    return new SidePage(driver);
  }

  @FindBy(css = ".top-card:nth-child(5)")
  WebElement interactions;

  public SidePage getInteractions() {
    click(interactions);
    return new SidePage(driver);
  }

  @FindBy(css = ".top-card:nth-child(1)")
  WebElement elements;

  public SidePage getElements() {
    click(elements);
    return new SidePage(driver);
  }

  @FindBy(css = ".top-card:nth-child(2)")
  WebElement forms;

  public SidePage getForms() {
    click(forms);
    return new SidePage(driver);
  }
}
