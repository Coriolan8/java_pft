package ru.stqa.pft.mantis.model;

/**
 * Created by Prelest on 06.09.2018.
 */
public class MailMessage {

    public String to;
    public String text;

    public MailMessage(String to, String text) {
      this.to = to;
      this.text = text;
    }

}
