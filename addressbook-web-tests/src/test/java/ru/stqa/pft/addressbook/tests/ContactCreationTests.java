package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.getContactHelper().createContact(new ContactData("Yulia",
            "Ve", "9(888)777-66-55", "prelest@gm.com", null));
  }




}
