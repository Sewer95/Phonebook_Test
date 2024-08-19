package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;

public class BrokenLinksImagesTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
       // new SidePage(driver).selectBrokenLinksImagesMenu().hideAds();
    }
}
