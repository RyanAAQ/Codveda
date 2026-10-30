package LevelTwo.BankApp;

public class BankApp {
    private double balance;

    public BankApp(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: #" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: #" + amount);
        } else if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public static void main(String[] args) {
        BankApp bankApp = new BankApp(1000.00);

        System.out.println("Initial Balance: #" + bankApp.getBalance());

        bankApp.deposit(500.00);
        System.out.println("Balance after deposit: #" + bankApp.getBalance());

        bankApp.withdraw(200.00);
        System.out.println("Balance after withdrawal: #" + bankApp.getBalance());



        try{
            System.out.println("Attempting to withdraw more than the balance");
            bankApp.withdraw(2000);
            
        }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
        }

        }
    }
