package com.prep.lld.adaptor;

import com.prep.lld.providers.AxisBankAPI;

/**
 * AxisBankAPIAdaptor
 */
public class AxisBankAPIAdaptor implements BankAPIAdaptor {

  AxisBankAPI api = new AxisBankAPI();
  double balance;

  @Override
  public int checkBalance(String accountNumber) {
    return this.api.checkBalance(Long.parseLong(accountNumber));
  }

  @Override
  public boolean deductBalance(int amount) {
    this.api.deductAmount(amount);
    return true;
  }

}
