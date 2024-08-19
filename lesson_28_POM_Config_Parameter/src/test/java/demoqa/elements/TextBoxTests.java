package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {
  HomePage homePage;
  SidePage sidePage;
  TextBoxPage textBoxPage;

  @BeforeMethod
  public void precondition() {
    homePage = new HomePage(app.driver);
    sidePage = new SidePage(app.driver);
    textBoxPage = new TextBoxPage(app.driver);

    homePage.getElements();
    sidePage.selectTextBoxMenu();
  }

  @Test
  public void keyboardEventTest() {
    textBoxPage
        .enterPersonalData("Beth","portishead@gmail.com")
        .keyBoardEventAddress("Portishead, Bristol, UK")
       .clickOnSubmitButton()
       .verifyCopyPasteText()
    ;
  }
}
