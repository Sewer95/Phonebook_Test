package phonebook.core;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import phonebook.fw.ContactHelper;
import phonebook.fw.HomeHelper;
import phonebook.fw.UserHelper;


import java.time.Duration;

public class ApplicationManager {
  private final String browser;
  public WebDriver driver;
  public WebDriverWait wait;
  UserHelper userHelper;
  HomeHelper homeHelper;
  ContactHelper contactHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
   // driver = new ChromeDriver();

    if(browser.equalsIgnoreCase("chrome")){
      driver = new ChromeDriver();
    } else if(browser.equalsIgnoreCase("firefox")){
      driver = new FirefoxDriver();
    }else if(browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    }else if(browser.equalsIgnoreCase("safari")){
      driver = new SafariDriver();
    }

    wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    driver.get("https://telranedu.web.app/home");
    driver.manage().window().setPosition(new Point(2500, 0));
    driver.manage().window().maximize(); // Развернуть браузер на весь экран
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Ожидание локатора
    userHelper = new UserHelper(driver, wait);
    homeHelper = new HomeHelper(driver, wait);
    contactHelper = new ContactHelper(driver, wait);
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }

  public HomeHelper getHomeHelper() {
    return homeHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public void stop() {
    driver.quit();
  }
}
