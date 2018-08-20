package ru.stqa.pft.addressbook.model;



import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String homenumber;
  private String mobilenumber;
  private String worknumber;
  private String allPhones;
  private String address;
  private String email1;
  private String email2;
  private String email3;
  private String group;
  private String allEmails;
  private File photo;

  public int getId() {
    return id;
  }


  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withHomenumber(String homenumber) {
    this.homenumber = homenumber;
    return this;
  }

  public ContactData withEmail(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withMobilenumber(String mobilenumber) {
    this.mobilenumber = mobilenumber;
    return this;
  }

  public ContactData withWorknumber(String worknumber) {
    this.worknumber = worknumber;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHomenumber() {
    return homenumber;
  }

  public String getEmail() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getWorknumber() {return worknumber; }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilenumber() {
    return mobilenumber;
  }

  public String getGroup() {
    return group;
  }

  public File getPhoto() {  return photo;  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
