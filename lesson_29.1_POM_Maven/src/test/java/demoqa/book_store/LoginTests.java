package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(app.driver).getBookStore();
    new SidePage(app.driver).selectLogin();
  }

  @Test(testName = "Login existing user with positive data")
  public void loginPositiveTest() {
    new LoginPage(app.driver)
        .enterPersonalData("root", "Qwertyuiop@1")
        .clickOnLoginButton()
        .verifyUserName("root");
  }
}
