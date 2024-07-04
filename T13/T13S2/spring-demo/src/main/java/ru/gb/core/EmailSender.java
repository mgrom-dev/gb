package ru.gb.core;

import org.springframework.stereotype.Component;

@Component("myEmailSender") // myEmailSender
public class EmailSender {

  // Inversion Of Control

  // @Autowired Field Injection
  private final EmailServerParameters parameters;
//  private final SessionFactory sessionFactory;

  // Если конструктор 1 - то @Autowired необязательна
  // @Autowired // Constructor injection - Dependency Injection
  public EmailSender(EmailServerParameters parameters) {
    this.parameters = parameters;
//    this.sessionFactory = sessionFactory;
  }

  public void sendEmail(String subject, String body, String recipient) {
    // ...
    System.out.println("Письмо [" + subject + "] отправлено получателю (" + recipient + ")");
    System.out.println("Адрес smpt: " + parameters.getEmailServerAddress());
  }

}
