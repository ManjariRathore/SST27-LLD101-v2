package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
  private final String userId;

  public WhatsAppDecorator(Notifier base, String userId) {
    super(base);
    this.userId = userId;
  }

  @Override
  public void notify(String text) {
    super.notify(text);
    System.out.println("whatsapp -> " + userId + ": " + text);
  }

}
