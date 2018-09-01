package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Yulia on 18.08.2018.
 */
public class ContactAddressEmailTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();
    app.goTo().HomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Yulia1").withLastname("Ve")
              .withHomenumber("9(888)777-66-55").withEmail("prelest@gm.com").inGroups(groups.iterator().next()));
    }
  }
  @Test
  public void testContactEmail() {
    ContactData contacts = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contacts);
    assertThat(contacts.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contacts.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}


