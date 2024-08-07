import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize(); // Развернуть браузер на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Ожидание локатора
    }



    public boolean isElementPresent(By locator){
        System.out.println("Проверка есть ли элемент на странице");
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod

    public void tearDown() {
        driver.quit();
    }
}
