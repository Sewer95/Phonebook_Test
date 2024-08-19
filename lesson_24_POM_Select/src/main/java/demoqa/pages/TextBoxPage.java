package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }


    public TextBoxPage enterDataWithJS(String name, String email, String address) {
        js.executeScript("document.getElementById('userName').value ='" + name + "';");
        js.executeScript("document.getElementById('userName').style.border='5px solid red';");

        js.executeScript("document.getElementById('userEmail').value ='" + email + "';");
        js.executeScript("document.getElementById('userEmail').style.border='10px solid blue';");

        js.executeScript("document.getElementById('currentAddress').value ='" + address + "';");
        js.executeScript("document.getElementById('currentAddress').style.border='15px solid green';");
        return this;
    }


    @FindBy(id = "submit")
    WebElement submitButton;

    public TextBoxPage clickOnSubmitButton() {
        clickWithScroll(submitButton, 200);
        return this;
    }


    public TextBoxPage getInnerTextWithJS() {
        String innerText = (String) js.executeScript("return document.getElementById('output').innerText;");
        System.out.println("Inner text is:\n" + innerText);

        String string = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println("All data:\n" + string);
        return this;
    }

    public TextBoxPage refreshPageWithJS() {
        js.executeScript("history.go(0);");
        return this;
    }

    public TextBoxPage checkPageTitle(String text) {
        String title = js.executeScript("return document.querySelector('h1.text-center').innerText").toString();
        assert title.equals(text);
        System.out.println("Title of page is: [" + title + "]");
        return this;
    }

    public TextBoxPage checkURLWithJs() {
        System.out.println("Current URL with JS: " + js.executeScript("return document.URL;").toString());
        System.out.println("Current URL with WebDriver: " + driver.getCurrentUrl());
        return this;
    }

    public TextBoxPage navigateToNewPageWithJS(String url) {
        // js.executeScript("window.open('" + url + "');");
        driver.get(url);
        return this;
    }

    public TextBoxPage generateAlertWithJS(String alertText) {
        js.executeScript("alert('" + alertText + "');");
        // js.executeScript("window .confirm = function(){return true};");
        pause(1000);
        driver.switchTo().alert().accept();
        return this;
    }
}
