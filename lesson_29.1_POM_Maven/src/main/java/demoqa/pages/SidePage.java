package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {
  public SidePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//span[.='Login']")
  WebElement login;

  public LoginPage selectLogin() {
    click(login);
    return new LoginPage(driver);
  }

  //@FindBy(xpath = "//span[contains(text(),'Alerts')]")
  @FindBy(xpath = "//span[.='Alerts']")
  WebElement alerts;

  public AlertsPage selectAlerts() {
    click(alerts);
    return new AlertsPage(driver);
  }

  @FindBy(xpath = "//span[.='Frames']")
  WebElement frames;

  public AlertsPage selectFrames() {
    click(frames);
    return new AlertsPage(driver);
  }

  @FindBy(xpath = "//span[.='Browser Windows']")
  WebElement browserWindows;

  public AlertsPage selectBrowserWindows() {
    click(browserWindows);
    return new AlertsPage(driver);
  }

  //************************ 24 урок *****************************

  @FindBy(xpath = "//span[.='Select Menu']")
  WebElement selectMenu;

  public WidgetsPage selectSelectMenu() {
    clickWithScroll(selectMenu, 500);
    return new WidgetsPage(driver);
  }

  @FindBy(xpath = "//span[.='Slider']")
  WebElement sliderMenu;

  public WidgetsPage selectSliderMenu() {
    clickWithScroll(sliderMenu, 500);
    return new WidgetsPage(driver);
  }


  @FindBy(xpath = "//span[.='Droppable']")
  WebElement droppable;

  public InteractionsPage selectDroppableMenu() {
    clickWithScroll(droppable, 500);
    return new InteractionsPage(driver);
  }


  @FindBy(xpath = "//span[.='Tool Tips']")
  WebElement toolTipsMenu;

  public SliderPage selectToolTipsMenu() {
    clickWithScroll(toolTipsMenu, 500);
    return new SliderPage(driver);
  }

  @FindBy(xpath = "//span[.='Buttons']")
  WebElement buttonsMenu;

  public ButtonsPage selectButtonsMenu() {
    clickWithScroll(buttonsMenu, 500);
    return new ButtonsPage(driver);
  }

  @FindBy(xpath = "//span[.='Upload and Download']")
  WebElement uploadMenu;

  public UploadDownloadPage selectUploadMenu() {
    clickWithScroll(uploadMenu, 500);
    return new UploadDownloadPage(driver);
  }

  @FindBy(xpath = "//span[.='Auto Complete']")
  WebElement autoCompleteMenu;

  public AutoCompletePage selectAutoCompleteMenu() {
    clickWithScroll(autoCompleteMenu, 500);
    return new AutoCompletePage(driver);
  }

  @FindBy(xpath = "//span[.='Text Box']")
  WebElement textBoxMenu;

  public TextBoxPage selectTextBoxMenu() {
    clickWithScroll(textBoxMenu, 500);
    return new TextBoxPage(driver);
  }

  @FindBy(xpath = "//span[.='Links']")
  WebElement linksMenu;

  public LinksPage selectLinksMenu() {
    clickWithScroll(linksMenu, 500);
    return new LinksPage(driver);
  }

  @FindBy(xpath = "//span[.='Broken Links - Images']")
  WebElement brokenLinksImagesMenu;

  public BrokenLinksImagesPage selectBrokenLinksImagesMenu() {
    clickWithScroll(brokenLinksImagesMenu, 500);
    return new BrokenLinksImagesPage(driver);
  }

  @FindBy(xpath = "//span[.='Practice Form']")
  WebElement practiceFormMenu;

  public PracticeFormPage selectPracticeFormMenu() {
    clickWithScroll(practiceFormMenu, 500);
    return new PracticeFormPage(driver);
  }
}
