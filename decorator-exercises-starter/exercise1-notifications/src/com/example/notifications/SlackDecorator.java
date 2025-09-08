package com.example.notifications;

public class SlackDecorator extends NotifierDecorator {

  public SlackDecorator(Notifier base) {
    super(base);
  }
  @Override
  public void notify(String text) {
    super.notify(text);
    System.out.println("slack: " + text);
  }
}
