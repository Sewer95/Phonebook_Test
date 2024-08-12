import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetsPageTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePage(driver).selectSelectMenu();
    }


    @Test
    public void oldStyleSelectMenuTest(){
        new WidgetsPage(driver).selectOldStyle("Indigo");
    }





}
