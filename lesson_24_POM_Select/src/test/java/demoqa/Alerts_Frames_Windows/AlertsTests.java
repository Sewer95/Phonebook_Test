package demoqa.Alerts_Frames_Windows;

import demoqa.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindow();
        new SidePage(driver).selectAlerts().hideAds();
    }

    @Test
    public void waitAlertsTests(){
        new AlertsPage(driver).clickAlertWithTimer();
    }

    @Test
    public void alertWithSelectText(){
        new AlertsPage(driver)
                .clickOnConfirmButton()
                .selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertTest(){
        new AlertsPage(driver)
                .sendMessageToAlert("Hello")
                .verifyMessage("Hello");
    }

}
