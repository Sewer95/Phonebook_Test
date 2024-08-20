package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InteractionsPage extends BasePage {
  public InteractionsPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "draggable")
  WebElement dragMe;

  @FindBy(id = "droppable")
  WebElement dragHere;

  public InteractionsPage actionDragMe() {
    pause(500);
    scrollPageDown();
    // Метод perform(): Этот метод фактически выполняет все действия, которые были подготовлены объектом Actions.
    // Без вызова perform(), действия, которые были подготовлены объектом Actions - не будут выполнены.
    new Actions(driver).dragAndDrop(dragMe, dragHere).perform();
    return this;
  }

  public InteractionsPage verifyText(String text) {
    assert text.equals(dragHere.getText());
    // shouldHaveText(dragHere, text, 500);
    // Assert только 1 всегда
    return this;
  }

  public InteractionsPage actionDragMeBy(int x, int y) {
    pause(500);
    // get coordinates dragMe (from) and print them
    int xOffsetFrom = dragMe.getLocation().getX();
    int yOffsetFrom = dragMe.getLocation().getY();
    System.out.println("dragMe: xOffsetFrom => " + xOffsetFrom + ", yOffsetFrom => " + yOffsetFrom + ".");

    // get coordinates dragHere (to) and print them
    int xOffsetTo = dragHere.getLocation().getX();
    int yOffsetTo = dragHere.getLocation().getY();
    System.out.println("dragHere: xOffsetTo => " + xOffsetTo + ", yOffsetTo => " + yOffsetTo + ".");

    // find the difference between the xOffset and xOffset
    pause(500);
    int xOffset = xOffsetTo - xOffsetFrom;
    int yOffset = yOffsetTo - yOffsetFrom;
    new Actions(driver).dragAndDropBy(dragMe,xOffset +x,yOffset+y).perform();
    return this;
  }
}
