package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
        for (int i = 0; i < colors.length; i++){
            if (colors[i] != null){
            inputSelect.sendKeys(colors[i]);
            inputSelect.sendKeys(Keys.ENTER);
            }
//            inputSelect.sendKeys(Keys.SPACE);
            click(space);
        }
        return this;
    }


    @FindBy(id = "cars")
    WebElement cars;
    public SelectMenuPage standardMultiSelectByIndex(int index) {

        Select select = new Select(cars);
        if (select.isMultiple()){
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
        assert selectedOptions.stream().anyMatch(element -> element.getText().equals(selectedText)) : "Error, text [" + selectedText + "] in index [" + index + "] not found" ;
    }

    public void standardMultiSelectByCars(String[] car) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            for(String element : car){
                select.selectByVisibleText(element);
            }
        }
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedText = selectedOptions
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String text : selectedText){
            System.out.println(text);
        }
        List<String> expectedText = Arrays.asList(car);
        assert new HashSet<>(selectedText).containsAll(expectedText);
    }
}
