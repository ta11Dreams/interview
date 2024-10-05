package com.prep.lld.adaptor;

/**
 * PhonePe
 */
public class PhonePe {

  BankAPIAdaptor adaptor;

  PhonePe(BankAPIAdaptor adaptor) {
    this.adaptor = adaptor;
  }

  boolean addMoneyToWallet(int amount, String accountNumber) {
    double accountBalance = adaptor.checkBalance(accountNumber);
    
    if ( amount > accountBalance ) return false;

    return adaptor.deductBalance(amount);
  }
}
