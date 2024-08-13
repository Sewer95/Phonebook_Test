package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.ButtonsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePage(driver).selectButtonsMenu().hideAds();
    }

    @Test
    public void doubleClickButtonsTest() {
        new ButtonsPage(driver)
                .doubleClick()
                .verifyDoubleClickMessage("You have done a double click");
    }
    @Test
    public void rightClickButtonsTest() {
        new ButtonsPage(driver)
                .rightClick()
                .verifyContextClickMessage("You have done a right click");
    }
    @Test
    public void dynamicClickButtonsTest() {
        new ButtonsPage(driver)
                .dynamicClick()
                .verifyDynamicClickMessage("You have done a dynamic click");
    }
}
