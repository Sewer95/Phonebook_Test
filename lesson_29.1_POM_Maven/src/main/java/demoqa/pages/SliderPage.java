package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class SliderPage extends BasePage {
  public SliderPage(WebDriver driver) {
    super(driver);
  }


  @FindBy(css = ".range-slider")
  WebElement sliderContainer;

  @FindBy(id = "sliderValue")
  WebElement sliderValue;

  public SliderPage moveSlider(int value) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    try {
      Robot robot = new Robot();
      click(sliderContainer);
      // Получаем текущее значение слайдера
      int currentValue = Integer.parseInt(sliderValue.getAttribute("value"));

      // Вычисляем разницу между текущим значением и целевым значением
      int difference = value - currentValue;

      // Если текущее значение равно целевому значению, ничего не делаем
      if (currentValue == value) {
        return this;
      }

// Нажимаем клавиши влево или вправо в зависимости от разницы
// Тернарный оператор. Если разница положительная, клавишу со стрелкой вправо;
// В противном случае нажмите клавишу со стрелкой влево.
// Math.abs(difference) возвращает абсолютное значение разницы.
// Это гарантирует, что цикл выполнится правильное количество раз, независимо от того, положительная разница или отрицательная.
// Если разница отрицательная (например, difference = -5), без использования Math.abs, цикл не выполнится ни разу, так как условие i < difference будет ложным с самого начала (0 < -5).
      int key = difference > 0 ? KeyEvent.VK_RIGHT : KeyEvent.VK_LEFT;
      for (int i = 0; i < Math.abs(difference); i++) {
        robot.keyPress(key);
        robot.keyRelease(key);
      }
      // Подождите, пока значение слайдера не станет равным целевому значению
      wait.until(ExpectedConditions.attributeToBe(sliderValue, "value", String.valueOf(value)));
    } catch (AWTException e) {
      e.printStackTrace();
    }
    return this;
  }


  public SliderPage verifySliderValue(int expectedValue) {
    // Получение фактического значения из элемента sliderValue
    String actualValue = sliderValue.getAttribute("value");
    assert actualValue.equals(String.valueOf(expectedValue));
    return this;
  }
}
