package demoqa.Alerts_Frames_Windows;

import demoqa.TestBase;
import demoqa.pages.BrowserWindowsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getAlertsFrameWindow();
        new SidePage(driver).selectBrowserWindows().hideAds();
    }


    @Test
    public void newTabTest(){
        new BrowserWindowsPage(driver)
                .switchToNextTab(1)
                .verifyTabTitle("sample page");
    }
}
