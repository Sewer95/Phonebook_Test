package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormPageTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(app.driver).getForms();
    new SidePage(app.driver).selectPracticeFormMenu().hideAds();
  }

  @Test
  public void PracticeFormTest(){
    new PracticeFormPage(app.driver)
        .enterPersonalData("Beth", "Gibbons","portishead@gmail.com", "1234567890")
        .selectGender("Female")
        //.chooseDateOfBirth("01 Jan 1965")
        .chooseDate("4","May", "1965")
        .enterSubjects(new String[]{"Math", "English"})
        .selectHobbies(new String[]{"Reading", "Music"})
        .uploadPicture("C:/Users/PORTISHEAD/Downloads/portishead/Beth.jpeg")
        .enterCurrentAddress("Portishead, Bristol, UK")
        .selectState("NCR")
        .selectCity("Delhi")
        .submitForm()
        .verifySuccessRegistration("Thanks for submitting the form")
    ;
  }

  @Test
  @Parameters({"firstName","lastName","email","phone"})
  public void PracticeFormTestWithParameter(String firstName, String lastName, String email, String phone){
    new PracticeFormPage(app.driver)
        .enterPersonalData(firstName,lastName,email,phone)
        .selectGender("Female")
        //.chooseDateOfBirth("01 Jan 1965")
        .chooseDate("4","May", "1965")
        .enterSubjects(new String[]{"Math", "English"})
        .selectHobbies(new String[]{"Reading", "Music"})
        .uploadPicture("C:/Users/PORTISHEAD/Downloads/portishead/Beth.jpeg")
        .enterCurrentAddress("Portishead, Bristol, UK")
        .selectState("NCR")
        .selectCity("Delhi")
        .submitForm()
        .verifySuccessRegistration("Thanks for submitting the form")
    ;
  }
}
