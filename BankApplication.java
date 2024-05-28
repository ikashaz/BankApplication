package Assignment1;

import java.util.Scanner;

public class BankApplication {
    //main method for Bank class
    public static void main(String[] args) {
        int ch;
        //create object(declare object)
        Bank b = new Bank("123452423242-0-7", 100000.00); //initialize value to object using constructor
        // Create a Scanner object to read input from the console
        Scanner in = new Scanner(System.in);
        //greeting the customers
        System.out.println("\n          BANK APPLICATION            \n");
        do {
            while (true) {
                //Displaying menu
                System.out.println("Menu :");
                System.out.println("1- Check Balance");
                System.out.println("2- Deposit");
                System.out.println("3- MoneyWithdraw");
                System.out.println("4- MoneyExit");
                System.out.println("Please enter your choice 1 | 2 | 3 | 4");
                //handling invalid menu choices & display error message and let user to try again
                if (in.hasNextInt()) { //make sure the input is integer
                    ch=in.nextInt();
                    if (ch == 1 || ch == 2 || ch==3 || ch==4) {
                        // Valid option
                        break; // Exit the loop
                    } else {
                        //display error if user enter numbers others than 1,2,3 or 4
                        System.out.println("Invalid option. Please enter a number 1 | 2 | 3.| 4 \n");
                    }
                } else {
                    // display error if user enter invalid input (not an integer)
                    System.out.println("Invalid input. Please enter a new choice. Please enter a number 1 | 2 | 3.| 4 \n");
                    in.next(); // Consume the invalid input
                    in.nextLine();
                }
            }
                switch (ch) {
                    case 1:
                        //display the current balance in the acc
                        System.out.println("Your balance : RM " + b.getAccBalance()+"\n");
                        break;

                    case 2:
                        //prompt user to enter amount to deposit
                        System.out.println("Please enter your deposit amount: RM");
                        double dep = in.nextDouble();
                        // call deposit method and display the updated amount
                        b.deposit(dep);
                        break;

                    case 3:
                        //prompt user to enter the amount to withdraw
                        System.out.println("Please enter your withdraw amount: RM");
                        double wd = in.nextDouble();
                        //call withdraw method and display the current balance
                        b.withdrawM(wd);
                        break;

                    case 4:
                        System.out.println("Thank you! Have a nice day.");
                        // Close the Scanner to avoid resource leaks and exit the program
                        in.close();
                        break;

                }
        } while(ch!=4);
        }
    }


