package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.AplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Yulia on 16.07.2018.
 */
public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);


  protected static final AplicationManager app
          = new AplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void LogTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));

  }

  @AfterMethod(alwaysRun = true)
  public void LogTestStop(Method m, Object[] p){
    logger.info("Stop test " + m.getName() + " with parameters " + Arrays.asList(p));

  }
  public void verifyListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData().withId(g.getId())
              .withName(g.getName())).collect(Collectors.toSet())));
    }
  }
    public void verifyListInUIForContacts() {
      if (Boolean.getBoolean("verifyUI")) {
        Contacts dbContacts = app.db().contacts();
        Contacts uiContacts = app.contact().all();
        assertThat(uiContacts, equalTo(dbContacts.stream().map((g) -> new ContactData()
                .withId(g.getId()).withFirstname(g.getFirstname()).withLastname(g.getLastname())
                .withHomenumber(g.getHomenumber()))
                .collect(Collectors.toSet())));
  }
  }
}
