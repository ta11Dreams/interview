package com.prep.lld.factory;

/**
 * AbstractUIFactory
 */
public class AbstractUIFactory {
  public static UIFactory getFactory(String type) {
    if ("windows".equalsIgnoreCase(type)) {
      return new WindowsFactory();
    } else if ("ios".equalsIgnoreCase(type)) {
      return new IOSFactory();
    } else {
      return null;
    }
  }
}
