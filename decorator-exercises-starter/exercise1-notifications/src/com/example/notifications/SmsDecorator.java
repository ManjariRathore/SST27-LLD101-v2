package com.example.notifications;

public class SmsDecorator extends NotifierDecorator {
  private final String phoneNumber;

  public SmsDecorator(Notifier base, String phoneNumber) {
    super(base);
    this.phoneNumber = phoneNumber;
  }

  @Override
  public void notify(String text) {
    super.notify(text);
    System.out.println("sms -> " + phoneNumber + ": " + text);
  }

}
