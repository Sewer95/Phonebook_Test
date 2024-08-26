package sconto.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import sconto.pages.HomePage;
import sconto.utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class HomePageSteps {
    HomePage homePage;

    public static String baseURL = PropertiesLoader.loadProperty("url");
    @Given("User is on HomePage")
    public void userIsOnHomePage(){

        homePage = open(baseURL, HomePage.class);
        getWebDriver().manage().window().maximize();
        homePage.acceptCookies();
    }



}