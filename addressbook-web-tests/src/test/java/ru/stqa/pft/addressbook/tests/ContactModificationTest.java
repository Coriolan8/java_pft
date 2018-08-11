package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Yulia on 20.07.2018.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod public void ensurePreconditions(){
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Yulia",
              "Ve", "9(888)777-66-55", "prelest@gm.com", null));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Yulia",
            "Ver", "9(888)777-66-55", "prelest@gm.com", null);
    app.getContactHelper().modifyContact(before, contact);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
