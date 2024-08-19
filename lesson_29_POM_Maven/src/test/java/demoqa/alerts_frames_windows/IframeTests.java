package demoqa.alerts_frames_windows;

import demoqa.core.TestBase;
import demoqa.pages.AlertsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTests extends TestBase {
  @BeforeMethod
  public void precondition(){
    new HomePage(app.driver).getAlertsFrameWindows();
    new SidePage(app.driver).selectFrames();
  }

  @Test
  public void iframesCalculateTest(){
    new AlertsPage(app.driver).getListOfFrames();
  }

  @Test
  public void switchToIframeByIndexTest(){
    new AlertsPage(app.driver)
        .switchToIframeByIndex(1)
        .verifyIframeText("This is a sample page");
  }

  @Test
  public void switchToIframeByNameTest(){
    new AlertsPage(app.driver)
        .switchToIframeByName("frame1")
        .verifyIframeText("This is a sample page");
  }

  @Test
  public void switchToIframeByIdTest(){
    new AlertsPage(app.driver)
        .switchToIframeById()
        .returnToMainContent() // Страница куда встроены все frame
        .verifyMainContentText("There are 2 Iframes in this page");
  }

}
