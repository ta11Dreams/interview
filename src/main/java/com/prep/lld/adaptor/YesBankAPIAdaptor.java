package com.prep.lld.adaptor;

import com.prep.lld.providers.YesBankAPI;

/**
 * YesBankAPIAdaptor
 */
public class YesBankAPIAdaptor implements BankAPIAdaptor {

  YesBankAPI api = new YesBankAPI();

  @Override
  public int checkBalance(String accountNumber) {
    return (int) this.api.checkBalance(accountNumber);
  }

  @Override
  public boolean deductBalance(int amount) {
    this.api.deductBalance((double) amount);
    return true;
  }

}
