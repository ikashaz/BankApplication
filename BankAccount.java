package Day10;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(int acc,double bal,String nm){
        this.accountNumber=acc;
        this.balance=bal;
        this.ownerName=nm;
    }

    public double getbalance(){
        return balance;
    }

    //deposit method to enter money to acc
    public void deposit(double amount){
        if( amount > 0){
            this.balance += amount;
            System.out.println("The current balance after deposit : RM"+ this.balance);

        } else{
            System.out.println("Please enter to valid amount");
        }
    }
    //withdraw money if have suffient amount
    public void withdraw(double amount){
        if(amount < balance ){
            balance -= amount;
            System.out.println("The current balance after withdraw : RM" + balance);
        } else {
            System.out.println("insuffient balance");
        }
    }

    public void displayAccountDetails(){
        System.out.println("Name :" + ownerName);
        System.out.println("Account Number :" +accountNumber);
        System.out.println("Current Balance: RM" + balance);
        System.out.println();
    }

    public static void main(String[] args) {

        BankAccount account1=new BankAccount(12345,10000.0,"sam");
        BankAccount account2=new BankAccount(67890,500.0,"Antonio");

        System.out.println("Balance :"+ account1.getbalance());
        account1.deposit(500.0);
        account1.withdraw(200.0);
        account1.displayAccountDetails();

        System.out.println("Balance :"+ account2.getbalance());
        account2.deposit(500.0);
        account2.withdraw(200.0);
        account2.displayAccountDetails();
    }
}
