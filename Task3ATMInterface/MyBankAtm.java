package Task3ATMInterface;

import java.util.Scanner;

abstract class BankAccount
{
    Scanner sc = new Scanner(System.in);
    int accountNo;
    double depositAmount;
    double withdrawAmount;
    static double totalBalance;
    abstract int deposit(double amount);
    abstract int withdraw(double amount);
    abstract void promptUserSelection();
    abstract void promptAccountNo();
    abstract void welcomeBankMessage();
}

class Atm extends BankAccount
{
    int deposit(double amount)
    {
        // System.out.println("Enter account no: ");
        // accountNo = sc.nextInt();

        // System.out.println("Enter the amount you want to deposit in account no: " + accountNo);
        // depositAmount = sc.nextDouble();
        System.out.println("Amount to deposit: " + amount);

        totalBalance += amount;

        System.out.println("\nDeposit transaction completed succesfully");

        System.out.println("Available balance: " + totalBalance);
        System.out.println("\n----------------------------------------------------------------");

        return 0;
    }
    
    int withdraw(double amount)
    {
        /* System.out.println("Enter account no: ");
        accountNo = sc.nextInt(); */

        // System.out.println("Enter the amount you want to withdraw from account no: " + accountNo);
        // withdrawAmount = sc.nextDouble();

        System.out.println("\nAmount to withdraw: " + amount);

        if(amount > totalBalance)
        {
            System.out.println("\n**** Insufficient Balance ****");
            System.out.println("Withdraw transaction cannot be completed");
        }
        else
        {
            totalBalance = totalBalance - amount;

            System.out.println("\nWithdraw transaction completed succesfully");
        }

        System.out.println("\nAvailable Balance: " + totalBalance);
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("");
        return 0;
    }

    double checkBalance()
    {
        System.out.println("\nAvailable Balance: " + totalBalance);
        System.out.println("\n----------------------------------------------------------------");
        return 0;
    }

    void promptAccountNo()
    {
        
        System.out.println("Enter your account no: ");
        accountNo = sc.nextInt();

        if (accountNo == 1234) 
        {
            promptUserSelection();
            //System.out.println("----------------------------------------------------------------");
        }
        else
        {
            System.out.println("\nPlease enter correct Account Number\n");
            promptAccountNo();
        }
    }

    void welcomeBankMessage()
    {
        System.out.println("\n==== Welcome to My Bank ATM ===== " );
    }

    void promptUserSelection()
    {
        //greetUser();

        System.out.println("\n*** Select Transaction type ***");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("Press -1 to Exit");
        //System.out.println("Press 1 to deposit and 2 to withdraw");
        int option = sc.nextInt();

        double amount;
        int anotherTransaction;

        switch(option)
            {
                case 1:
                    System.out.println("\nEnter the amount you want to deposit in account no " + accountNo);
                    amount = sc.nextDouble();
                    deposit(amount);

                    System.out.println("\nDo you want to perform another transaction?");
                    System.out.println("1. Yes");
                    System.out.println("2. No\n");

                    anotherTransaction = sc.nextInt();

                    switch(anotherTransaction)
                    {
                        case 1:
                            promptUserSelection();
                            break;

                        case 2:
                            return;
                    }

                    break;

                case 2:
                    System.out.println("\nEnter the amount you want to withdraw from account no " + accountNo);
                    amount = sc.nextDouble();
                    withdraw(amount);

                    System.out.println("\nDo you want to perform another transaction?");
                    System.out.println("1. Yes");
                    System.out.println("2. No\n");

                    anotherTransaction = sc.nextInt();

                    switch(anotherTransaction)
                    {
                        case 1:
                            promptUserSelection();
                            break;

                        case 2:
                            return;
                    }

                    break;

                case 3: 
                    checkBalance();
                    promptUserSelection();
                    break;

                case -1:
                    sc.close();
                    return;
            }    
    }
}

public class MyBankAtm {
    public static void main(String[] args) 
    {
        BankAccount obj = new Atm();

        obj.welcomeBankMessage();
        obj.promptAccountNo();
    }
}
