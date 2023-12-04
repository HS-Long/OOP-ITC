public class BankAccount {
    static int totalAccount = 0;
    String accountHolder;
    double balance;

    public BankAccount(String accountHolder, double initbalance) {
        this.accountHolder = accountHolder;
        this.balance = initbalance;
        totalAccount++;
    }
public void displayAcc(){
    System.out.println("Acc holder: " + accountHolder);
    System.out.println("Balance: " + balance);
}
public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit of $" + amount + "Succesful.");
        }else{
            System.out.println("invalid deposit amount.");
        }
}
public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw of $" + amount + "succesful.");
        }else{
            System.out.println("Invalid withdraw amount or insuffcient founds.");
        }
}
public static void displayTotalacc(){
    System.out.println("Total bank account: " + totalAccount);
}
}
