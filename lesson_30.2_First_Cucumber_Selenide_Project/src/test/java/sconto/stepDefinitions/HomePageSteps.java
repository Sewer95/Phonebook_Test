package sconto.stepDefinitions;

import io.cucumber.java.en.Given;
import sconto.pages.HomePage;
import static com.codeborne.selenide.Selenide.open;



public class HomePageSteps {
    HomePage homePage;

    @Given("User is on HomePage")
    public void userIsOnHomePage(){
        homePage = open();
    }
}