package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().groups().size() == 0){
    app.goTo().GroupPage();
    app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void testGroupDelition() {
    Groups before = app.db().groups();
    GroupData deleteGroup = before.iterator().next();
    app.goTo().GroupPage();
    app.group().delete(deleteGroup);
    assertEquals(app.group().count(),before.size() - 1);
    Groups after = app.db().groups();

    assertThat(after, equalTo(before.without(deleteGroup)));

  }

}

