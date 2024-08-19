package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxJSTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePage(driver).selectTextBoxMenu().hideAds();
    }

    @Test
    public void JSExecutorTest(){
        new TextBoxPage(driver)
                .enterDataWithJS("User Name", "serega@gmail.com", "Berlin")
                .clickOnSubmitButton()
                .getInnerTextWithJS()
                .refreshPageWithJS()
                .checkPageTitle("Text Box")
                .checkURLWithJs()
                .navigateToNewPageWithJS("https://www.google.com/")
                .generateAlertWithJS("Hello JS Alert");

    }

}
