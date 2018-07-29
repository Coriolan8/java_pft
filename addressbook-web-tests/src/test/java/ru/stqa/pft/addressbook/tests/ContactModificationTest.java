package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Yulia on 20.07.2018.
 */
public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yulia",
              "Ve", "9(888)777-66-55", "prelest@gm.com", null));
    }
    app.getContactHelper().startContactEdit();
    app.getContactHelper().fillContactForm(new ContactData("Yulia",
            "Ver", "9(888)777-66-55", "prelest@gm.com", null), false);
    app.getContactHelper().submitContactEdit();
    app.getNavigationHelper().gotoHomePage();
  }
}
