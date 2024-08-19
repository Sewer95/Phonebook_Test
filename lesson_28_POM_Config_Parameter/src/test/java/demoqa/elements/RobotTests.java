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
    new HomePage(app.driver).getElements();
    new SidePage(app.driver).selectUploadMenu().hideAds();
  }

  @Test
  public void performKeyEventWithRobotTest(){
    new UploadDownloadPage(app.driver)
        .performKeyEventWithRobot()
        .verifyPath("C:\\fakepath\\Test.txt");
  }

  @Test
  public void performMouseEventTests() {
    new UploadDownloadPage(app.driver)
        .preformMouseEvent()
        .verifyPath("C:\\fakepath\\Test.txt");
  }
}
