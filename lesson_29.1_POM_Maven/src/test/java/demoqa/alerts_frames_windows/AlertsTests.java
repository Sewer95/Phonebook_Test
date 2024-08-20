package demoqa.alerts_frames_windows;

import demoqa.core.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(app.driver).getAlertsFrameWindows();
    new SidePage(app.driver).selectAlerts().hideAds();
  }

  @Test
  public void waitAlertsTests() {
    new AlertsPage(app.driver).clickAlertWithTimer();
  }

  @Test
  public void alertWithSelectText(){
    new AlertsPage(app.driver)
        .clickOnConfirmButton()
        .selectResult("OK")
        .verifyResult("Ok");
  }

  @Test
  public void sendMessageToAlertTest(){
    new AlertsPage(app.driver)
        .sendMessageToAlert("Hello")
        .verifyMessage("Hello");
  }
}
