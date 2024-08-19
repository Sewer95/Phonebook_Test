package demoqa.core;

import demoqa.utils.MyListener;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;

public class ApplicationManager {
  protected String browser;
  public WebDriver driver;
  Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  protected void startTest() {
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
    } else if (browser != null &&
        !browser.equalsIgnoreCase("chrome") &&
        !browser.equalsIgnoreCase("firefox") &&
        !browser.equalsIgnoreCase("safari") &&
        !browser.equalsIgnoreCase("edge")) {
      logger.error("Browser entered is not correct");
      throw new IllegalArgumentException("Browser entered is not correct");
    }


    WebDriverListener listener = new MyListener();
    driver = new EventFiringDecorator<>(listener).decorate(driver);

    driver.manage().window().setPosition(new Point(2500, 0));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.get("https://demoqa.com/");
  }

  protected void stopTest() {
    String os = System.getProperty("os.name").toLowerCase();
    try {
      if (os.contains("mac")) {
        driver.quit();
      } else if (os.contains("win")) {
        driver.quit();
      }
    } catch (Exception e) {
      System.err.println("\033[31m" + "Exception while quitting the WebDriver: " + e.getMessage() + "\033[0m");
    } finally {
      driver = null;
      if (os.contains("win")) {
        try {
          new ProcessBuilder("taskkill", "/F", "/IM", "chromedriver.exe", "/T").start();
        } catch (IOException e) {
          System.err.println("IOException while trying to kill chromedriver.exe: " + e.getMessage());
          e.printStackTrace();
        }
      }
    }
  }
}
