package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Yulia on 01.09.2018.
 */
public class ContactAddToGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsGroup(){
    if (app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1"));
    }
    Groups groups = app.db().groups();
    if (app.db().contacts().size() == 0){
    app.goTo().HomePage();
    app.contact().create(new ContactData().withFirstname("Yulia2").withLastname("Ve")
            .withHomenumber("9(888)777-66-55").withEmail("prelest@gm.com").inGroups(groups.iterator().next()));
  }
}
  @Test
  public void testContactAddToGroup(){
    Groups groups = app.db().groups();
    ContactData randomContact = app.db().contacts().iterator().next();
    Groups groupsBefore = randomContact.getGroups();
    ContactHelper helper = app.contact();
    for (GroupData groupData : groups) {
      if (!helper.containInGroups( groupsBefore, groupData)) {
        app.goTo().HomePage();
        helper.addToGroup(randomContact, groupData.getId());
        groupsBefore.add(groupData);
        Groups groupsAfter = helper.extractContact(app.db().contacts(), randomContact.getId()).getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore));
        return;
      }
    }

    app.goTo().GroupPage();
    GroupData group = new GroupData().withName("groupForContact")
            .withHeader("headerForContact").withFooter("footerForContact");
    app.group().create(group);
    int groupId = app.db().groups().stream().mapToInt(GroupData::getId).max().getAsInt();
    app.goTo().HomePage();
    helper.addToGroup(randomContact, groupId);
    groupsBefore.add(group.withId(groupId));
    Groups groupsAfter = helper.extractContact(app.db().contacts(), randomContact.getId()).getGroups();
    assertThat(groupsAfter, equalTo(groupsBefore));
  }
}





