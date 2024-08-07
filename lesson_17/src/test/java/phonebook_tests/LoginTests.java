package phonebook_tests;

import org.testng.Assert;
import org.testng.annotations.*;
import phonebook.model.User;

public class LoginTests extends TestBase {

  @BeforeClass
  public void beforeClass() {
    System.out.println("*****BeforeClass*****");
  }

  @BeforeMethod
  public void ensurePrecondition() {
    System.out.println("******BeforeMethod*****");
    if (!app.getUserHelper().isLoginLinkPresent()) {
      app.getUserHelper().clickOnSignOutButton();
    }
  }

  @Test
  public void loginExistedUserPositiveTest() {
    app.getUserHelper().loginExistedUserPositive();
    app.getUserHelper().isSignOutButtonPresent();
  }

  @Test
  public void loginUserWitOutPasswordNegativeTest() {
    app.getUserHelper().clickLoginLink();
    app.getUserHelper().fillInRegistrationForm(new User().setEmail("user_admin_new3@gmail.com"));
    app.getUserHelper().clickOnLoginButton();
    Assert.assertTrue(app.getUserHelper().isAlertPresent());
  }

  @AfterMethod
  public void AfterMethod() {
    System.out.println("******AfterMethod*****");
  }

  @AfterClass
  public void AfterClass() {
    System.out.println("*****AfterClass*****");
  }
}

