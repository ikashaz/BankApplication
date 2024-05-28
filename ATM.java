package Day11;

import Day10.BankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

//this class represent bank acc with the balance
class BankAcc{
    private double balance;

    //create a new bank acc n initial
    public BankAcc(double balance){
        this.balance=balance;
    }
    //withdraw the specific amount from  acc
    public void withdraw(double amount) throws InsuffientFundsException{
        if (amount > balance){
            //throw a custom exception if balance insufficient
            throw new InsuffientFundsException("Insuffient fund for withdraw");
        }
        balance -= amount;
        System.out.println("Withdraaw successful. New balance: "+ balance);
    }
}
// a custom exception class thrown when there are insufficient funds in the bank acc
class InsuffientFundsException extends Exception{
    public InsuffientFundsException(String e){
        super(e);//call the super class constructor to set the error message
    }
}
//this class simulates on ATM that allow users to withdraw money
public class ATM {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        BankAcc b= new BankAcc(109);

        while(true){
            try{

                System.out.println("Enter amount to withdraw: ");
                double amount= in.nextInt();
                //call withdraw method with user input
                b.withdraw(amount);
                break;//exit loop successfully withdraw
            }catch (InputMismatchException e){
                System.out.println("invalid input. Please enter a valid number");
                in.nextLine();//clear scanner buffer
            }catch (InsuffientFundsException e){
                System.out.println("Error :"+ e.getMessage());
            }

        }
    }
}
