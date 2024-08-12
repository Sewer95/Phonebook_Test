package demoqa.widgets;

import demoqa.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SelectMenuPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePage(driver).selectSelectMenu();
    }


    @Test
    public void oldStyleSelectMenuTest(){
        new SelectMenuPage(driver).selectOldStyle("Indigo");
    }

    @Test
    public void multiSelectMenuTest(){
        new SelectMenuPage(driver).multiSelect(new String[]{"Green", "Blue"});
    }

    @Test
    public void standardMiltiSelectByIndexTest(){
        new SelectMenuPage(driver).standardMultiSelectByIndex(0).verifyByIndex(0);
    }

    @Test
    public void standardMiltiSelectByCarsTest(){
        new SelectMenuPage(driver).standardMultiSelectByCars(new String[]{"Volvo", "Audi"});
    }





}
