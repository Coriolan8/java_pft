package ru.stqa.pft.addressbook.model;



import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name ="addressbook")
@XStreamAlias("contact")
public class ContactData {
  @Id
  @Column(name = "id")
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  @Expose
  private String firstname;
  @Column(name = "lastname")
  @Expose
  private String lastname;
  @Column(name = "home")
  @Type(type = "text")
  @Expose
  private String homenumber;
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilenumber;
  @Column(name = "work")
  @Type(type = "text")
  private String worknumber;
  @Transient
  private String allPhones;
  @Type(type = "text")
  @Column(name = "address")
  @Expose
  private String address;
  @Type(type = "text")
  @Column(name = "email")
  @Expose
  private String email1;
  @Type(type = "text")
  @Column(name = "email2")
  private String email2;
  @Type(type = "text")
  @Column(name = "email3")
  private String email3;
  @Transient
  private String group;
  @Transient
  private String allEmails;
  @Transient
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public int getId() {
    return id;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (homenumber != null ? !homenumber.equals(that.homenumber) : that.homenumber != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    return email1 != null ? email1.equals(that.email1) : that.email1 == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (homenumber != null ? homenumber.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (email1 != null ? email1.hashCode() : 0);
    return result;
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

  public File getPhoto() {  return new File(photo);  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}
