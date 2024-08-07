import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
        return !driver.findElements(locator).isEmpty();
    }

    @AfterMethod (enabled = false)

    public void tearDown() {
      driver.quit();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();

    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert().accept();
            return true;
        }
    }

    public void loginExistedUserPositive() {
        click(By.xpath("//a[.='LOGIN']"));
        type(By.name("email"), "user_admin777_new@gmail.com");
        type(By.name("password"), "Password@1");
        click(By.name("login"));
    }

    public boolean isContactAdded(String textToFind) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts){
            if(element.getText().contains(textToFind))
                return true;
        }
        return false;
    }

    protected void addNewContactPositiveData(String name) {
        click(By.xpath("//a[.='ADD']"));
        // enter name
        type(By.xpath("//input[@placeholder='Name']"), name);
        // enter lastName
        type(By.xpath("//input[@placeholder='Last Name']"), "TestLastName");
        // enter phone
        type(By.xpath("//input[@placeholder='Phone']"), "1234567890");
        // enter email
        type(By.xpath("//input[@placeholder='email']"), "admin@gmail.com");
        // enter address
        type(By.xpath("//input[@placeholder='Address']"), "Germany, Berlin");
        // enter description
        type(By.xpath("//input[@placeholder='description']"), "My Contact test");
        // click on Save button
        click(By.xpath("//b[.='Save']"));
    }

    protected int sizeOfContacts() {
        if(isElementPresent(By.className("contact-item_card__2SOIM"))){
            driver.findElements(By.className("contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
