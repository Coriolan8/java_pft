package ru.stqa.pft.mantis.model;

/**
 * Created by Yulia on 08.09.2018.
 */
public class Project {

  private int id;
  private String name;

  public int getId() {
    return id;
  }
  public Project withId(int id) {
    this.id = id;
    return this;
  }
  public String getName() {
    return name;
  }
  public Project withName(String name) {
    this.name = name;
    return this;
  }
}

