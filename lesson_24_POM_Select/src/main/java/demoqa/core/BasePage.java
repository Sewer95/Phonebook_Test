package demoqa.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public abstract class   BasePage {
   public WebDriver driver;
   public JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);

        }
    }
    public void typeWithJs(WebElement element, String text, int scroll) {
        if (text != null) {
            clickWithJs(element, 0, scroll);
            element.clear();
            element.sendKeys(text);

        }
    }

    public void clickWithJs(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(" + x + " , " + y + ")");
        click(element);
    }

    public void shouldHaveText(WebElement element, String text, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            throw new AssertionError("The text [" + text + "] was not found in the [" + element + "] within [" + timeout + "] milliseconds");
        } catch (UnhandledAlertException e) {
            throw new AssertionError("No alert present wile waiting for text [" + text + "] in the [" + element.getTagName() + "]");
        }
    }

    public void clickWithScroll(WebElement element, int pixelDown){
        scrollPage(pixelDown);
        click(element);
    }

    public static void scrollPage(int pixels) {
        try {
            Robot robot = new Robot();
            // Press and hold the "Page Down" key for scrolling down
            for (int i = 0; i < pixels / 120; i++) { // 120 pixels is approximately one "Page Down"
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(100); // Delay to allow the scroll to register
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveTo(int x, int y) {
        new Actions(driver).moveByOffset(x, y).perform();
    }

    public void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void hideAds(){
        js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
        js.executeScript("document.querySelector('footer').style.display='none';");
    }
}
