package sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import sconto.utils.PropertiesLoader;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.*;

public class LoginPage {

    public static String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static String validPassword = PropertiesLoader.loadProperty("valid.password");

    //  @FindBy(className = "existingAccount__headline")
//  WebElement formTitle;
//
//  public SelenideElement verifyFormTitle() {
//    return $(formTitle).shouldBe(exist);
//  }

    public SelenideElement verifyFormTitle() {
        return $(className("existingAccount__headline")).shouldBe(exist);
    }

    public LoginPage validLoginInput() {
        $(xpath("//input[@data-testid='loginEmailInput']")).val(validEmail);
        $(id("loginPassword")).val(validPassword);
        return Selenide.page(LoginPage.class);
    }

    public HomePage clickOnAnmeldenButton() {
        $(xpath("//button[@data-testid='login-submit']")).click();
        return Selenide.page(HomePage.class);
    }
}
