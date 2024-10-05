package com.prep.lld.providers;

public class AxisBankAPI {

  private int balance;

  public int checkBalance(long accountNumber) {
    return this.balance;
  }

  public int deductAmount(int amount) {
    this.balance = this.balance - amount;
    return this.balance;
  }

}
