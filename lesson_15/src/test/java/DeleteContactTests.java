import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    private final String CONTACT_NAME = "TestName";
    @BeforeMethod
    public void precondition(){
        loginExistedUserPositive();
        addNewContactPositiveData(CONTACT_NAME);
    }

    @Test
    public void deleteContactPositiveTest(){
        int sizeBefore = sizeOfContacts();
        // get size before delete
        click(By.className("contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));

        // get size after delete
        int sizeAfterDelete = sizeOfContacts();
        // compare between before and after
        Assert.assertEquals(sizeBefore, sizeAfterDelete);
    }


    @Test
    public void deleteAllContacts(){
        while(hasContacts()){
            //click on contact
            click(By.className("contact-item_card__2SOIM"));
            //click on remove contact
            click(By.xpath("//button[text()='Remove']"));
        }
        Assert.assertEquals(sizeOfContacts(), 0);

    }

    private boolean hasContacts() {
        return isElementPresent(By.className("contact-item_card__2SOIM"));
    }

}
