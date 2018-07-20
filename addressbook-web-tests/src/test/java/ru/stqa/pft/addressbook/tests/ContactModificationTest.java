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
    app.getContactHelper().startContactEdit();
    app.getContactHelper().fillContactForm(new ContactData("Yulia", "Ver", "9(888)777-66-55", "prelest@gm.com"));
    app.getContactHelper().submitContactEdit();
    app.getNavigationHelper().gotoHomePage();
  }
}
