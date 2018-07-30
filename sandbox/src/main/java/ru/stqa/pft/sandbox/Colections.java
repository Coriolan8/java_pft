package ru.stqa.pft.sandbox;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yulia on 30.07.2018.
 */
public class Colections {

  public static void main(String[] args){
    String [] langs = {"Java", "C#", "Phyton", "PHP"};
    List<String>  languages = Arrays.asList("Java", "C#", "Phyton", "PHP");
  
    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
