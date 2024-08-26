package sconto.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;

public class CustomerAccountPage {
    public SelenideElement verifyUserName(String name) {
        return $(className("titleHeadline")).shouldHave(text(name));
    }
}
