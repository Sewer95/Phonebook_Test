package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.BrokenLinksImagesPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements();
        new SidePage(app.driver).selectBrokenLinksImagesMenu().hideAds();
    }

    @Test
    public void checkBrokenImages(){
        new BrokenLinksImagesPage(app.driver)
            .checkBrokenImages();
    }
}
