package com.prep.lld.providers;

/**
 * YesBankAPI
 */
public class YesBankAPI {

  private double balance = 10000.0;

  public double checkBalance(String accountNumber) {
    return this.balance;
  }

  public double deductBalance(double amount) {
    this.balance = this.balance - amount;

    return this.balance;
  }
}
