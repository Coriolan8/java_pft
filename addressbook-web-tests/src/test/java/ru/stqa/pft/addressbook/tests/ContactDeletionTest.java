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
    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Yulia",
              "Ve", "9(888)777-66-55", "prelest@gm.com", null));
    }
  }

  @Test
  public void testContactDeletion() {

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size() - 1, after.size());

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
