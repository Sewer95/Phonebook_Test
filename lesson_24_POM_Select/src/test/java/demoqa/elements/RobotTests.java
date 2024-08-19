package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.UploadDownloadPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RobotTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePage(driver).selectUploadMenu().hideAds();
    }

    @Test
    public void chooseKeyEventWithRobotTest() {
        new UploadDownloadPage(driver)
                .chooseKeyEventWithRobot()
                .verifyPath("C:\\fakepath\\Test.txt");

    }
}
