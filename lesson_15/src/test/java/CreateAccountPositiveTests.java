import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountPositiveTests extends TestBase {
    @Test
    public void createAccountPositiveTest() {
        // Click on Login Link [href="/login"]
        driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        //enter email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("user_admin777_new@gmail.com");
        //driver.findElement(By.xpath("//input[@placeholder='Email']"));

        // enter password

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Password@1");
        // click on Registration button
        driver.findElement(By.name("registration")).click();
        System.out.println("Button 'registration' is pressed and User is registered successfully");
        // Assert that button
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    @Test
    public void createAccountPositiveTestRefactor() {

        click(By.xpath("//a[.='LOGIN']"));
        type(By.name("email"), "user_admin777_new@gmail.com");
        type(By.name("password"), "Password@1");
        click(By.name("registration"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[.='Sign Out']")));
    }

    @Test
    public void createExistedAccountNegativeTest() {

        SoftAssert softAssert = new SoftAssert();

        click(By.xpath("//a[.='LOGIN']"));
        type(By.name("email"), "user_admin777_new@gmail.com");
        type(By.name("password"), "Password@1");
        click(By.name("registration"));
       // Assert.assertTrue(isAlertPresent());
        softAssert.assertTrue(isAlertPresent());
        //Assert.assertTrue(isElementPresent(By.xpath("//div[.='Registration failed with code 409']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//div[.='Registration failed with code 409']")));
        softAssert.assertAll();
    }


}
