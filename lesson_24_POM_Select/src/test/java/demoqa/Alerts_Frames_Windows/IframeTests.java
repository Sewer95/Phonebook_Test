package demoqa.Alerts_Frames_Windows;

import demoqa.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTests extends TestBase {
    @BeforeMethod
    public void precondition(){

        new HomePage(driver).getAlertsFrameWindow();
        new SidePage(driver).selectFrames();
    }

    @Test
    public void iframesCalculateTest(){
        new AlertsPage(driver).getListOfFrames();
    }


    @Test
    public void switchToIframeByIndexTest(){
        new AlertsPage(driver)
                .switchToIframeByIndex(2)
                .verifyIframeText("This is a sample page");
    }
    @Test
    public void switchToIframeByNameTest(){
        new AlertsPage(driver)
                .switchToIframeByName("frame1")
                .verifyIframeText("This is a sample page");
    }
    @Test
    public void switchToIframeByIdTest(){
        new AlertsPage(driver)
                .switchToIframeById()
                .returnToMainContent()
                .verifyMainContentText("There are 2 Iframes in this page");
    }
}
