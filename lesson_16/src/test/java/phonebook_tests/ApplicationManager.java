package phonebook_tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ApplicationManager extends BaseHelper {
    protected static final String CONTACT_NAME = "TestName";
    private static final String BUTTON_REMOVE = "//button[text()='Remove']";
    private static final String CONTACT_LOCATOR = "contact-item_card__2SOIM";
    WebDriver driver;
    WebDriverWait wait;

    public boolean isElementPresent(By locator){
      System.out.println("Проверка есть ли элемент [" + locator + "] на странице");
      try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
      } catch (TimeoutException e) {
        return false;
      }
    }

    public void type(By locator, String text) {
      if(text != null){
      click(locator);
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
      }
    }

    public void click(By locator) {
      try {
        // Пытаемся кликнуть, если элемент кликабелен
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
      } catch (TimeoutException te) {
        // Обработка исключения, если время ожидания истекло
        System.out.println("Время ожидания элемента истекло: " + locator);
        throw te;
      } catch (WebDriverException e) {
        // Если элемент не кликабелен, проверяем, видим ли он
        try {
          wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
          // Если элемент видим, пытаемся снова кликнуть
          driver.findElement(locator).click();
        } catch (WebDriverException ex) {
          // Логирование или другая обработка исключения
          System.out.println("Не удалось кликнуть по элементу: " + locator);
          throw ex;
        }
      }
    }

    public boolean isAlertPresent() {
      Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
      if(alert == null){
        return false;
      }else{
        driver.switchTo().alert().accept();
        return true;
      }
    }

    public void loginExistedUserPositive() {
      clickLoginLink();
      fillInRegistrationForm(new User()
          .setEmail("user_admin_new3@gmail.com")
          .setPassword("Password@1"));
      clickOnLoginButton();
    }

    void fillInRegistrationForm(User user) {
      type(By.name("email"), user.getEmail());
      type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginButton() {
      click(By.name("login"));
    }

    public void clickLoginLink() {
      click(By.xpath("//a[.='LOGIN']"));
    }

    public boolean isContactAdded(String textToFind) {
      List<WebElement> contacts = driver.findElements(By.cssSelector("h2")); // сколько h2 - столько и контактов
      for(WebElement element : contacts){
        if(element.getText().contains(textToFind))
          return true;
      }
      return false;
    }

    public void addNewContactPositiveData(String name) {
      //click on Add link
      click(By.xpath("//a[.='ADD']"));
      //enter name
      type(By.xpath("//input[@placeholder='Name']"), name);
      //enter lastname
      type(By.xpath("//input[@placeholder='Last Name']"), "TestLastName");
      //enter phone
      type(By.xpath("//input[@placeholder='Phone']"), "1234567890");
      //enter email
      type(By.xpath("//input[@placeholder='email']"), "admin@gmail.com");
      //enter address
      type(By.xpath("//input[@placeholder='Address']"), "Germany, Berlin");
      //enter description
      type(By.xpath("//input[@placeholder='description']"), "My contact test");
      //click on Save button
      click(By.xpath("//b[.='Save']"));
    }

    public int actualSizeOfContacts() {
      if(isElementPresent(By.className(CONTACT_LOCATOR))){
        return driver.findElements(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div")).size();
      }
      return 0;
    }

    public void deleteOneContactOnly() {
      click(By.className(CONTACT_LOCATOR));
      click(By.xpath("//button[text()='Remove']"));
    }

    public void isSignOutButtonPresent() {
      Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    protected void deleteAllContacts() {
      try {
        while (hasContacts()) { // Цикл пока контакты не закончатся
          // Шаг 1: Получить текущее количество контактов
          int contactsBefore = actualSizeOfContacts();
          // Шаг 2: Выполнить удаление контакта
          click(By.className(CONTACT_LOCATOR));
          click(By.xpath(BUTTON_REMOVE));
          // Шаг 3: Ожидать, пока количество контактов на странице не станет меньше
          /*
           * Лямбда-выражение, которое принимает экземпляр WebDriver и возвращает true или false.
           * WebDriver d - параметр лямбда-выражения, представляющий текущий экземпляр драйвера.
           * Условие проверяет, уменьшилось ли количество контактов на странице по сравнению с исходным значением contactsBefore
           * */
          wait.until((WebDriver d) -> actualSizeOfContacts() < contactsBefore);
        }
      } catch (NoSuchElementException e) {
        System.out.println("Все контакты были удалены.");
      }
    }

    private boolean hasContacts() {
      // Проверьте, нет ли контактов, не дожидаясь долго
      return isElementPresent(By.className(CONTACT_LOCATOR));
    }
}
