package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UploadDownloadPage extends BasePage {

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "uploadFile")
    WebElement uploadFile;
    public UploadDownloadPage chooseKeyEventWithRobot() {
        pause(500);
        clickRectangle(uploadFile, 2,2);
        Robot robot;
        try{
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.delay(1000);
        //вводим текст "Test.txt"
        // Вводим заглавную букву T
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_SHIFT);

        //e
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);

        //s
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);

        //t
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);

        // .
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyRelease(KeyEvent.VK_PERIOD);

        //t
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);

        //x
        robot.keyPress(KeyEvent.VK_X);
        robot.keyRelease(KeyEvent.VK_X);

        //t
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);

        //Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return this;
    }


    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;
    public UploadDownloadPage verifyPath(String path) {
        verifyMessage(uploadedFilePath, path);
        return this;
    }
}
