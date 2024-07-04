package ru.gb.core;

import org.springframework.stereotype.Component;

@Component
public class EmailServerParameters {

  private final String emailServerAddress;
  private final String login;
  private final String password;

  public EmailServerParameters() {
    this.emailServerAddress = "smtp://google:35";
    this.login = "user";
    this.password = "P@$$";
  }

  public String getEmailServerAddress() {
    return emailServerAddress;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }
}
