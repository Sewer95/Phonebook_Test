package demoqa.alerts_frames_windows;

import demoqa.core.TestBase;
import demoqa.pages.BrowserWindowsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTests extends TestBase {
  @BeforeMethod
  public void precondition(){
    new HomePage(app.driver).getAlertsFrameWindows();
    new SidePage(app.driver).selectBrowserWindows().hideAds();
  }

  @Test
  public void newTabTest(){
    new BrowserWindowsPage(app.driver)
        .switchToNextTab(1)
        .verifyTabTitle("sample page");
  }
}
