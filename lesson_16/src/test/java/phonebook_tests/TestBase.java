package phonebook_tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase extends ApplicationManager {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() {
    init();
  }

  private void init() {
    app.driver = new ChromeDriver();
    app.wait = new WebDriverWait(app.driver, Duration.ofMillis(2000));
    app.driver.get("https://telranedu.web.app/home");
    app.driver.manage().window().setPosition(new Point(2500, 0));
    app.driver.manage().window().maximize(); // Развернуть браузер на весь экран
    app.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Ожидание локатора
  }

  @AfterMethod(enabled = true)
  public void tearDown() {
    stop();
  }

  private void stop() {
    app.driver.quit();
  }

}
