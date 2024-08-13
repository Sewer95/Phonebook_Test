package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(css =".range-slider")
    WebElement sliderContainer;

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage moveSlider(int value) {
        try {
            Robot robot = new Robot();
            clickWithJs(sliderContainer, 0, 200);
            int currentValue = Integer.parseInt(sliderValue.getAttribute("value"));
            int difference = value - currentValue;

            if (currentValue == value){
                return this;
            }

            int key = difference > 0 ? KeyEvent.VK_RIGHT : KeyEvent.VK_LEFT;

            pause(500);
            for(int i = 0; i < Math.abs(difference); i++){
                robot.keyPress(key);
                robot.keyRelease(key);
            }
            System.out.println(difference);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    public SliderPage verifySliderValue(int expectedValue) {
        String actualValue = sliderValue.getAttribute("value");
        assert actualValue.equals(String.valueOf(expectedValue));
        return this;
    }
}
