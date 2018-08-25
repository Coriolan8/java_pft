package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.AplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

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
}
