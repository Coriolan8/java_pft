package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.AplicationManager;

/**
 * Created by Yulia on 16.07.2018.
 */
public class TestBase {


  protected static final AplicationManager app
          = new AplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }


  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
