package com.example.notifications;

public abstract class NotifierDecorator implements Notifier {
  protected final Notifier notifier;

  protected NotifierDecorator(Notifier notifier) {
    this.notifier = notifier;
  }

  @Override
  public void notify(String text) {
    notifier.notify(text);
  }
}
