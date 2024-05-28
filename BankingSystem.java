package Day6;
//acc class
class acc{
    protected int accnumb;
    protected double balance;

    //constructor to initialize the acc num and balance
    public acc(int ac){
        this.accnumb=ac;
        this.balance=0.0;
    }
    //method to deposit money into bank
    public void deposit(double amount){
        balance +=amount;
    }

    //method withdraw money from account
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
        }else {
            System.out.println("Insufficient money");
        }
    }

    //method to get current balance of the acc
    public double getbalance(){
        return balance;
    }
}

class Savingacc extends acc{
    private final double interestRate;

    //constructor to initialize acc numb,interest and call based constructor
    public Savingacc(int acc,double ir){
        super(acc);
        this.interestRate=ir;
    }
    //method to add interest to the saving acc balance
    public void addinterest(){
        double interst=balance+interestRate/100;
        deposit(interst);
    }

}

class checkingAcc extends acc{
    private final double overdraflimit;

    //constructor
    public checkingAcc(int acc,double overd){
        super(acc);
        overdraflimit=overd;
    }

    //override the withdraw method to include overdraf limit
    @Override
    public void withdraw(double amount){
        if(balance +overdraflimit >= amount){
            balance -=amount;
        }else{
            System.out.println("Exceeded overdraft limit");
        }
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        //create instances of savingsacc and checking acc
        Savingacc sa=new Savingacc(1234567, 0.2);
        checkingAcc ca= new checkingAcc(879028,2.0);
        //deposit money
        sa.deposit(1000);
        System.out.println("ACCOUNT BALANCE :"+ sa.getbalance());
        //withdraw
        sa.withdraw(300.00);
        System.out.println("BALANCE AFTER WITHDRAW: RM"+sa.getbalance());

        //add interest to saving and print balance
        sa.addinterest();
        System.out.println("BALANCE AFTER INTEREST: RM"+ sa.getbalance());

        //
    }
}
