import java.util.Scanner;

class BankAccount{
    private float balance;

    public BankAccount(float initialAmount){
        this.balance = initialAmount;
    }

    public float balance(){
        return balance;
    }

    public void deposit(float amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposit of " + amount + "₹ is successfull");
        } else {
            System.out.println("Invalid entry. Please choose a number above 0");
        }
    }

    public void withdraw(float amount){
        if (amount > 0 && amount <= balance){
            System.out.println("Withdraw successfull of "+amount+"Rs");
            balance -= amount;
            System.out.println("Remaining balance"+" "+balance);
        } else {
            System.out.println("Invaid entry!!.Insuffucient balance or negative value entered");
        }
    }
}

class OperationsinATM{

    private BankAccount account; 
    public OperationsinATM(BankAccount account){
        this.account = account;
    }

    public void display(){
        System.out.println("Select Options");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Leave");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            display();
            System.out.println("Pick an option");
            option = sc.nextInt();
            
            switch (option){
                case 1:
                    System.out.println("Enter amount to deposit");
                    float depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw");
                    float withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance " + account.balance());
                    break;
                case 4:
                    System.out.println("Thanks for working with pandey Bank");
                    break;
                default:
                    System.out.println("Invalid entry!!. Enter only the given options");   
            }
        }while (option != 4);
        sc.close();;
    }
}

public class ATM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(100000);
        OperationsinATM at = new OperationsinATM(userAccount);
        System.out.println("Enter Your PIN");
        String pin = sc.nextLine();
        if (pin.equals("1234")) {
            at.run();
        } else {
            System.out.println("Wrong pin");      
        } 
      sc.close();      
    }
}
