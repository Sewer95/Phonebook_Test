package demoqa.interactions;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.InteractionsPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SidePage(driver).selectDroppableMenu().hideAds();
    }

    @Test
    public void actionDragMeTest() {
        new InteractionsPage(driver)
                .actionDragMe()
                .verifyText("Dropped!");
    }

    @Test
    public void actionDragMeByTest() {
        new InteractionsPage(driver)
                .actionDragMeBy(5, 5)
                .verifyText("Dropped!");
    }


}
