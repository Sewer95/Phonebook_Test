package phonebook_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import phonebook.core.ApplicationManager;

public class TestBase {

  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));

  //@BeforeMethod
  @BeforeSuite
  public void setUp() {
    System.out.println("****BeforeSuite****");
    app.init();
  }
  //@AfterMethod(enabled = true)
  @AfterSuite
  public void tearDown() {
    System.out.println("****AfterSuite");
    app.stop();
  }
}
