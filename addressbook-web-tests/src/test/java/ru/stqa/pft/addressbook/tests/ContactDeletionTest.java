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
public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0){
    app.goTo().HomePage();
      app.contact().create(new ContactData().withFirstname("Yulia").withLastname("Ve")
              .withHomenumber("9(888)777-66-55").withEmail("prelest@gm.com").inGroups(groups.iterator().next()));
    }
  }

  @Test
  public void testContactDeletion() {

    Contacts before = app.db().contacts();
    ContactData deleteContact = before.iterator().next();
    app.goTo().HomePage();
    app.contact().delete(deleteContact);
    app.goTo().HomePage();
    Contacts after = app.db().contacts();
    Assert.assertEquals(before.size() - 1, after.size());

    assertThat(after, equalTo(before.without(deleteContact)));
    verifyListInUIForContacts();
  }


}
