package phonebook_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
  public void precondition() {
    app.loginExistedUserPositive();
    app.addNewContactPositiveData(ApplicationManager.CONTACT_NAME);
  }

  @Test(invocationCount = 1)
  public void createOneAndDeleteOneContactPositiveTest() {
    // Шаг 1: Получить текущее количество контактов
    int sizeBefore = app.actualSizeOfContacts();
    // Шаг 2: Удалить контакт
    app.deleteOneContactOnly();
    // Шаг 3: Получить количество контактов после удаления
    int sizeAfterDelete = app.actualSizeOfContacts();
    // Шаг 4: Проверить, что количество контактов уменьшилось на 1
    Assert.assertEquals(sizeBefore, sizeAfterDelete);
  }

  @Test
  public void deleteAllContactsTests() {
    app.deleteAllContacts();
    Assert.assertEquals(app.actualSizeOfContacts(), 0, "Not all contacts were deleted.");
  }

}
