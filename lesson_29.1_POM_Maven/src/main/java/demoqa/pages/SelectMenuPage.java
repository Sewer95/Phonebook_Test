package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SelectMenuPage extends BasePage {
  public SelectMenuPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "oldSelectMenu")
  WebElement oldSelectMenu;

  public SelectMenuPage selectOldStyle(String color) {
    Select select = new Select(oldSelectMenu);
    select.selectByVisibleText(color);
    return this;
  }

  @FindBy(id = "react-select-4-input")
  WebElement inputSelect;

  @FindBy(css = "html")
  WebElement space;

  public SelectMenuPage multiSelect(String[] colors) {
    for (int i = 0; i < colors.length; i++) {
      if (colors[i] != null) {
        inputSelect.sendKeys(colors[i]);
        inputSelect.sendKeys(Keys.ENTER);
      }
      inputSelect.sendKeys(Keys.RIGHT);
      click(space);
    }
    return this;
  }

  @FindBy(id = "cars")
  WebElement cars;

  public SelectMenuPage standardMultiSelectByIndex(int index) {
    Select select = new Select(cars);
    if (select.isMultiple()) {
      select.selectByIndex(index);
    }
    List<WebElement> options = select.getOptions();
    String selectedText = options.get(index).getText();
    System.out.println(selectedText);
    return this;
  }

  public void verifyByIndex(int index) {
    Select select = new Select(cars);
    List<WebElement> options = select.getOptions();
    List<WebElement> selectedOptions = select.getAllSelectedOptions();
    String selectedText = options.get(index).getText();
    // Стрим (Stream) в Java — это интерфейс, предоставляющий функциональный подход для обработки коллекций данных.
    // С помощью стримов можно выполнять операции над элементами коллекций (например, фильтрацию, преобразование, сортировку) в функциональном стиле, что делает код более читабельным и лаконичным.
    // Стримы позволяют работать с данными в виде потока, применяя цепочку операций, которые могут быть выполнены последовательно или параллельно.
    // Ассерт прослушивая поток с примером текста ошибки.
    assert selectedOptions.stream().anyMatch(element -> element.getText().equals(selectedText)) : "Error, text [" + selectedText + "] in index [" + index + "] not found";
  }


  public void standardMultiSelectByCars(String[] car) {
    Select select = new Select(cars);
    if (select.isMultiple()) {
      for (String element : car) {
        select.selectByVisibleText(element);
      }
    }
    List<WebElement> selectedOptions = select.getAllSelectedOptions();

    List<String> selectedText = selectedOptions
        .stream()
        // WebElement::getText — это ссылка на метод. В данном контексте это сокращенная запись для метода getText() класса WebElement.
        // метод getText() будет вызываться для каждого элемента потока selectedOptions.
        // Это позволяет извлечь текст из каждого элемента и преобразовать его в строку.
        .map(WebElement::getText)
        // map — это промежуточная операция, которая преобразует каждый элемент потока, применяя к нему функцию getText() класса WebElement.
        .collect(Collectors.toList());
        // .collect(): Это терминальная операция, которая завершает потоковые операции и накапливает результаты в коллекцию, указанную коллектором. В этом случае List
    for (String text : selectedText) {
      System.out.println(text);
    }
    List<String> expectedText = Arrays.asList(car);
    // HashSet Множество автоматически удаляет дублирующиеся элементы и предоставляет быстрый доступ к элементам.
    assert new HashSet<>(selectedText)
        // Проверка, содержит ли HashSet все элементы expectedText:
        .containsAll(expectedText);
  }

}