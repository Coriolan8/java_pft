package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Yulia on 04.09.2018.
 */
public class RegistrationTests extends TestBase{

  @Test
  public void testRegistration(){
    app.registration().start("user1", "user1@localhost.localdomain");
  }
}