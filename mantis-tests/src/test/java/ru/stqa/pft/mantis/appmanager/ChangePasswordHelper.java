package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yulia on 07.09.2018.
 */
public class ChangePasswordHelper extends HelperBase{

  public ChangePasswordHelper(ApplicationManager app) {
    super(app);
  }
  public void adminLogin(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.xpath("//input[@name='username']"), username);
    click(By.xpath("//*[@id='login-form']/fieldset/input[2]"));
    type(By.xpath("//input[@name='password']"), password);
    click(By.xpath("//*[@id='login-form']/fieldset/input[3]"));
  }
  public void userSettings() {
    click(By.linkText("Manage"));
    wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    click(By.linkText("Manage Users"));
  }
  public void selectUser() {
    click(By.xpath("//*[@id='main-container']//*[contains(text(), 'user')]"));
  }
  public void resetUserPassword() {
    click(By.xpath("//*[@id='manage-user-reset-form']"));
  }
  public String getEmail() {
    String email = wd.findElement(By.xpath("//tr[3]//input[@name='email']")).getAttribute("value");
    return email;
  }
  public String getName() {
    String name = wd.findElement(By.xpath("//tr[1]//input[@name='username']")).getAttribute("value");
    return name;
  }

}
