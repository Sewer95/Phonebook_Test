package phonebook.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phonebook.fw.ContactHelper;
import phonebook.fw.HomeHelper;
import phonebook.fw.UserHelper;
import phonebook.utils.MyListener;

import java.io.IOException;
import java.time.Duration;

public class ApplicationManager {
  private final String browser;
  public WebDriver driver;
  public WebDriverWait wait;
  UserHelper userHelper;
  HomeHelper homeHelper;
  ContactHelper contactHelper;
  public static Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equalsIgnoreCase("chrome")) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-search-engine-choice-screen");
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(options);
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    } else if (browser.equalsIgnoreCase("safari")) {
      driver = new SafariDriver();
    }

    WebDriverListener listener = new MyListener();
    driver = new EventFiringDecorator<>(listener).decorate(driver);
    wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    driver.get("https://telranedu.web.app/home");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
    String os = System.getProperty("os.name").toLowerCase();
    try {
      if (os.contains("mac")) {
        //logger.info(os.toString());
        driver.quit();
      } else if (os.contains("win")) {
        //logger.info(os.toString());
        //logger.warn("\033[32m" + "Closing WebDriver: " + driver + "\033[0m");
        driver.quit();
        //logger.warn("\033[31m" + "Driver has been successfully closed." + "\033[0m");
      }
    } catch (Exception e) {
      logger.error("\033[31m" + "Exception while quitting the WebDriver: " + e.getMessage() + "\033[0m");
    } finally {
      driver = null;
      if (os.contains("win")) {
        try {
          new ProcessBuilder("taskkill", "/F", "/IM", "chromedriver.exe", "/T").start();
        } catch (IOException e) {
          logger.warn("IOException while trying to kill chromedriver.exe: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
  }

}
