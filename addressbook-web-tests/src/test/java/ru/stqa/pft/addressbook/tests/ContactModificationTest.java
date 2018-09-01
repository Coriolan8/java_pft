package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 20.07.2018.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod public void ensurePreconditions(){
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0){
    app.goTo().HomePage();
    app.contact().create(new ContactData().withFirstname("Yulia2").withLastname("Ve")
              .withHomenumber("9(888)777-66-55").withEmail("prelest@gm.com").inGroups(groups.iterator().next()));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    app.goTo().HomePage();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Yulia1")
            .withLastname("Ver").withHomenumber("9(888)777-66-55").withEmail("prelest@gm.com").withAddress("524sladfjowerji");
    app.contact().modify(contact);
    app.goTo().HomePage();
    Contacts after = app.db().contacts();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyListInUIForContacts();
  }
}
