package demoqa.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://demoqa.com/");
    }

    @AfterMethod (enabled = false)
    public void tearDown() {
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
