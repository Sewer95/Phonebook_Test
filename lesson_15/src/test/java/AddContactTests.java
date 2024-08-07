import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{
    private final String CONTACT_NAME = "TestName";
    @BeforeMethod
    public void precondition(){
        loginExistedUserPositive();
    }

    @Test
    public void addContactPositiveTest(){
        // Click on ADD linkButton
        addNewContactPositiveData(CONTACT_NAME);
        // Assert by text
        Assert.assertTrue(isContactAdded(CONTACT_NAME));
    }

    @AfterMethod
    public void postCondition(){
        //Click in contact card
        click(By.className("contact-item_card__2SOIM"));
        //Click on Remove button
        click(By.xpath("//button[text()='Remove']"));

    }

}
