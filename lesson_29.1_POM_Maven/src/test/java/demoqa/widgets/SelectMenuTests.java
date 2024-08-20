package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SelectMenuPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(app.driver).getWidgets();
    new SidePage(app.driver).selectSelectMenu();
  }

  @Test
  public void oldStyleSelectMenuTest() {
    new SelectMenuPage(app.driver).selectOldStyle("Indigo");
  }

  @Test
  public void multiSelectMenuTest(){
    new SelectMenuPage(app.driver).multiSelect(new String[]{"Green","Blue"});
  }

  @Test
  public void standardMultiSelectByIndexTest(){
    new SelectMenuPage(app.driver).standardMultiSelectByIndex(0).verifyByIndex(0);
  }

  @Test
  public void standardMultiSelectByCarsTest(){
    new SelectMenuPage(app.driver).standardMultiSelectByCars(new String[]{"Volvo","Opel", "Saab"});
  }

}
