package com.az.dev.threads.banking;

import com.az.dev.threads.main.App;

/**
 * Created by bmziarkash on 6/5/16.
 */
public class AccountDanger implements Runnable {

    private Account account = new Account();

    public static void main(String[] args) {
        App.objectiveString = "Synchronizing thread access to shared data";
        App.addSub(App.objectiveString);

        AccountDanger accountDanger = new AccountDanger();

        Thread aminsCard = new Thread(accountDanger);
        Thread varunsCard = new Thread(accountDanger);
        aminsCard.setName("Amin Ziarkash");
        varunsCard.setName("Varun Aggarwal");
        aminsCard.start();
        varunsCard.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("\nAccount is overdrawn!");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount) { // Note the keyword synchronized here
        System.out.println("\nCurrentbalance\t:\t" + account.getBalance());

        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + "\t:\tis going to withdraw");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Withdrawing caught an exception");
            }
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + "\t:\tcompletes the withdrawal");
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + account.getBalance());
        }
    }
}
