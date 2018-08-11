package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Yulia on 20.07.2018.
 */
public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Yulia1").withLastname("Ve")
              .withHomenumber("9(888)777-66-55").withEmail("prelest@gm.com"));
    }
  }

  @Test
  public void testContactDeletion() {

    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().HomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(index);
    Assert.assertEquals(before, after);
  }


}
