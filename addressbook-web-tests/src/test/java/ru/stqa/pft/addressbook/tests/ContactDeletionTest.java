package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Yulia on 20.07.2018.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yulia",
              "Ve", "9(888)777-66-55", "prelest@gm.com", null));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoHomePage();
  }
}
