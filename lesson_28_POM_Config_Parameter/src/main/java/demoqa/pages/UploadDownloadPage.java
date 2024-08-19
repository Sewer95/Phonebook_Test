package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadDownloadPage extends BasePage {
  public UploadDownloadPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "uploadFile")
  WebElement uploadFile;

  public UploadDownloadPage performKeyEventWithRobot() {
    pause(500);
    //click(uploadFile);
    clickRectangle(uploadFile, 2, 2);
    Robot robot;
    try {
      robot = new Robot();
    } catch (AWTException e) {
      throw new RuntimeException(e);
    }
    robot.delay(1000);

    // Command + Tab для переключения на окно загрузки файла у Mac
    if (System.getProperty("os.name").contains("Mac")) {
      robot.keyPress(KeyEvent.VK_META);
      robot.keyPress(KeyEvent.VK_TAB);
      robot.keyRelease(KeyEvent.VK_TAB);
      robot.keyRelease(KeyEvent.VK_META);
    }

    // вводим текст "Test.txt"
    // Вводим заглавную букву Т
    robot.keyPress(KeyEvent.VK_SHIFT);
    robot.keyPress(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_SHIFT);

    // e
    robot.keyPress(KeyEvent.VK_E);
    robot.keyRelease(KeyEvent.VK_E);

    // s
    robot.keyPress(KeyEvent.VK_S);
    robot.keyRelease(KeyEvent.VK_S);

    // t
    robot.keyPress(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_T);

    // .
    robot.keyPress(KeyEvent.VK_PERIOD);
    robot.keyRelease(KeyEvent.VK_PERIOD);

    // t
    robot.keyPress(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_T);

    // x
    robot.keyPress(KeyEvent.VK_X);
    robot.keyRelease(KeyEvent.VK_X);

    // t
    robot.keyPress(KeyEvent.VK_T);
    robot.keyRelease(KeyEvent.VK_T);

    // Enter
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    return this;
  }

  @FindBy(id = "uploadedFilePath")
  WebElement uploadedFilePath;

  public UploadDownloadPage verifyPath(String path) {
    verifyMessage(uploadedFilePath, path);
    return this;
  }
  public UploadDownloadPage preformMouseEvent() {
    // Переносим начало из предыдущего метода
    pause(1000);
    clickRectangle(uploadFile, 10, 3);
    Robot robot;
    try {
      robot = new Robot();
    } catch (AWTException e) {
      throw new RuntimeException(e);
    }
    // Найдём размер экрана
    Dimension dimension = driver.manage().window().getSize();
    // Получаем размеры экрана
    int screenWidth = dimension.width;
    int screenHeight = dimension.height;
    System.out.println("Dimension X and Y: "+ screenWidth + " and "+ screenHeight);

    // Находим координаты центра правой нижней части экрана
    int x = screenWidth - (screenWidth / 4); // Вычисляет X-координату, начиная с правого края экрана и двигаясь влево на 1/4 ширины экрана.
    int y = screenHeight - (screenHeight / 2); // Вычисляет Y-координату, начиная с нижнего края экрана и двигаясь вверх на 1/2 высоты экрана.

    robot.mouseMove(x+50,y); // перемещает курсор на 50 пикселей вправо от вычисленного X-значения, оставляя Y-координату без изменений.


    pause(1000);
    // Клик мышкой по файлу
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
    return this;
  }
}
