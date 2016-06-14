package com.az.dev.banking;

/**
 * Created by bmziarkash on 6/5/16.
 */
public class Account {

    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }
}
