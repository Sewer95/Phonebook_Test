package phonebook_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @Test
  public void loginExistedUserPositiveTest(){
    app.loginExistedUserPositive();
    app.isSignOutButtonPresent();
  }

  @Test
  public void loginUserWithOutPasswordNegativeTest(){
    app.clickLoginLink();
    app.fillInRegistrationForm(new User()
            .setEmail("user_admin_new3@gmail.com"));
    app.clickOnLoginButton();
    Assert.assertTrue(app.isAlertPresent());
  }
}

