package demoqa.widgets;

import demoqa.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePage(driver).selectSliderMenu();
    }

    @Test
    public void moveSliderTest(){
       final int sliderValue = 60;
        new SidePage(driver)
                .moveSlider(sliderValue)
                .verifySliderValue(sliderValue);
    }
}
