package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Yulia on 20.07.2018.
 */
public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().gotoHomePage();
  }
}
