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
        //click(bookStore);
        clickWithJs(bookStore, 0, 500);
        return new SidePage(driver);
    }


    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFrameWindows;
    public SidePage getAlertsFrameWindow() {
        clickWithJs(alertsFrameWindows, 0, 300);
        return new SidePage(driver);
    }


    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;
    public SidePage getWidgets() {
        clickWithScroll(widgets, 200);
        return new SidePage(driver);
    }
}
