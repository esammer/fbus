package com.cloudera.fbus;

import org.springframework.integration.core.Message;

public class DeliveryException extends Exception {

  private static final long serialVersionUID = 1L;

  private Message<?> sourceMessage;

  public DeliveryException() {
    super();
  }

  public DeliveryException(Throwable t) {
    super(t);
  }

  public DeliveryException(String message, Throwable t) {
    super(message, t);
  }

  public DeliveryException(String message) {
    super(message);
  }

  public Message<?> getSourceMessage() {
    return sourceMessage;
  }

  public void setSourceMessage(Message<?> sourceMessage) {
    this.sourceMessage = sourceMessage;
  }

  public static <T> DeliveryException newWith(Message<T> sourceMessage, Throwable t) {
    DeliveryException e;

    e = new DeliveryException(t);

    e.setSourceMessage(sourceMessage);

    return e;
  }

  public static <T> DeliveryException newWith(Message<T> sourceMessage,
      String message, Throwable t) {
    DeliveryException e;

    e = new DeliveryException(message, t);

    e.setSourceMessage(sourceMessage);

    return e;
  }

}
