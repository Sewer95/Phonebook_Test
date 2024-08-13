package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {
    public SidePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //span[.='Login']")
    WebElement login;
    public LoginPage selectLogin() {
        clickWithJs(login, 0, 200);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {

        click(alerts);
        return new AlertsPage(driver);
    }


    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;
    public AlertsPage selectFrames() {
        clickWithJs(frames, 0, 300);
        return new AlertsPage(driver);
    }


    @FindBy(xpath = "//span[.='Browser Windows']")

    WebElement browserWindows;
    public AlertsPage selectBrowserWindows() {
        clickWithJs(browserWindows, 0, 300);
        return new AlertsPage(driver);
    }


    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;
    public WidgetsPage selectSelectMenu() {
        clickWithScroll(selectMenu, 500);
        return new WidgetsPage(driver);
    }


    @FindBy(xpath = "//span[.='Slider']")
    WebElement slidertMenu;
    public WidgetsPage selectSliderMenu() {
        clickWithJs(slidertMenu, 0, 300);
        return new WidgetsPage(driver);
    }


    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    public InteractionsPage selectDroppableMenu() {
        clickWithJs(droppable, 0, 400);
        return new InteractionsPage(driver);
    }


    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTipsMenu;
    public SliderPage selectToolTipsMenu() {
        clickWithJs(toolTipsMenu, 0, 400);
        return new SliderPage(driver);
    }


    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttonsMenu;
    public ButtonsPage selectButtonsMenu() {
        clickWithScroll(buttonsMenu, 500);
        return new ButtonsPage(driver);
    }
}
