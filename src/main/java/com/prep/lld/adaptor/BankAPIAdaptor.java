package com.prep.lld.adaptor;

/**
 * BankAPIAdaptor
 */
public interface BankAPIAdaptor {

  public int checkBalance(String accountNumber);
  public boolean deductBalance(int amount);
}
