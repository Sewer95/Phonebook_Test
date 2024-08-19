package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {
  public PracticeFormPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "firstName")
  WebElement firstName;
  @FindBy(id = "lastName")
  WebElement lastName;
  @FindBy(id = "userEmail")
  WebElement userEmail;
  @FindBy(id = "userNumber")
  WebElement userNumber;

  public PracticeFormPage enterPersonalData(String name, String surName, String email, String phone) {
    type(firstName, name);
    type(lastName, surName);
    type(userEmail, email);
    type(userNumber, phone);
    return this;
  }

  public PracticeFormPage selectGender(String gender) {
    try {
      String xpathGender = String.format("//label[.='" + gender + "']");
      WebElement genderLocator = driver.findElement(By.xpath(xpathGender));
      click(genderLocator);
    } catch (NoSuchElementException e) {
      System.out.println("Gender element not found: [" + gender + "]");
      throw new RuntimeException(e);
    } catch (Exception e) {
      System.out.println("Error selecting gender: [" + gender + "]");
      throw new RuntimeException(e);
    }
    return this;
  }

  @FindBy(id = "dateOfBirthInput")
  WebElement dateOfBirthInput;

  public PracticeFormPage chooseDateOfBirth(String date) {
    clickWithJs(dateOfBirthInput, 0, 200);
    String os = System.getProperty("os.name");
    if (os.contains("Mac")) {
      dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
    } else {
      dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
    }
    dateOfBirthInput.sendKeys(date);
    dateOfBirthInput.sendKeys(Keys.ENTER);
    return this;
  }

  @FindBy(id = "subjectsInput")
  WebElement subjectsInput;

  public PracticeFormPage enterSubjects(String[] subjects) {
    for (String subject : subjects) {
      if (subject != null) {
        type(subjectsInput, subject);
        subjectsInput.sendKeys(Keys.ENTER);
      }
    }
    return this;
  }

  public PracticeFormPage selectHobbies(String[] hobbies) {
    for (String hobby : hobbies) {
      try {
        String hobbyXpath = String.format("//label[.='" + hobby + "']");
        WebElement hobbyElement = driver.findElement(By.xpath(hobbyXpath));
        click(hobbyElement);
      } catch (Exception e) {
        System.out.println("Error selecting hobby: " + hobby);
        throw new RuntimeException(e);
      }
    }
    return this;
  }


  @FindBy(id = "uploadPicture")
  WebElement uploadPicture;

  public PracticeFormPage uploadPicture(String imgPath) {
    uploadPicture.sendKeys(imgPath);
    return this;
  }

  @FindBy(id = "currentAddress")
  WebElement currentAddress;

  public PracticeFormPage enterCurrentAddress(String address) {
    type(currentAddress, address);
    return this;
  }

  @FindBy(id = "state")
  WebElement stateContainer;

  @FindBy(id = "react-select-3-input")
  WebElement stateInput;

  public PracticeFormPage selectState(String state) {
    click(stateContainer);
    stateInput.sendKeys(state);
    stateInput.sendKeys(Keys.ENTER);
    return this;
  }

  @FindBy(id = "react-select-4-input")
  WebElement cityInput;
  @FindBy(id = "city")
  WebElement cityContainer;


  public PracticeFormPage selectCity(String city) {
    click(cityContainer);
    cityInput.sendKeys(city);
    cityInput.sendKeys(Keys.ENTER);
    return this;
  }

  @FindBy(id = "submit")
  WebElement submit;

  public PracticeFormPage submitForm() {
    click(submit);
    return this;
  }

  @FindBy(id = "example-modal-sizes-title-lg")
  WebElement registrationModal;

  public PracticeFormPage verifySuccessRegistration(String registrationMessage) {
    verifyMessage(registrationModal, registrationMessage);
    return this;
  }
  @FindBy(css = ".react-datepicker__month-select")
  WebElement monthContainer;
  @FindBy(css = ".react-datepicker__year-select")
  WebElement yearContainer;

  public PracticeFormPage chooseDate(String day, String month, String year) {
    clickWithJS(dateOfBirthInput, 0, 200);
    new Select(monthContainer).selectByVisibleText(month);
    new Select(yearContainer).selectByVisibleText(year);
    driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='"+ day +"']")).click();
    return this;
  }
}
