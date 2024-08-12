package demoqa.book_store;

import demoqa.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePage(driver).selectLogin();

    }

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver)
                .enterPersonalData("Serega","Qwertzuiop@1")
                .clickOnLoginButton()
                .verifyUserName("Serega");
    }
}
