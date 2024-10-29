import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw() {
        System.out.println("Enter the amount you want to withdraw: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        if (account.withdraw(amount)) {
            System.out.println("Amount Withdrawn Successfully: " + amount);
        }
    }

    public void deposit() {
        System.out.println("Enter the amount you want to deposit: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        account.deposit(amount);
        System.out.println("Amount Deposited Successfully: " + amount);
    }

    public void checkBalance() {
        System.out.println("Your account balance is: " + account.getBalance());
    }

    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            atm.displayMenu();
            System.out.println("Please enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.withdraw();
                    break;
                case 2:
                    atm.deposit();
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
        scanner.close();
    }
}