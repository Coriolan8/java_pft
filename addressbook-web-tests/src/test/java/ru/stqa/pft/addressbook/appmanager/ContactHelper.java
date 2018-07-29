package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Yulia on 18.07.2018.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getHomenumber());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      if (contactData.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    acceptAlert();
  }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void startContactEdit() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactEdit() {
    click(By.name("update"));
  }

  public void createContact(ContactData contact) {
    addNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
    returnHomePage();
  }

  public boolean isThereAContact() {
   return isElementPresent(By.name("selected[]"));
  }
}

