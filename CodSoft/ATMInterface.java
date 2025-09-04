import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}

// Class representing the ATM interface
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Choose an option: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    private void displayMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("✅ Withdrawal successful. Please collect your cash.");
        } else {
            System.out.println("❌ Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("✅ Deposit successful.");
        } else {
            System.out.println("❌ Deposit failed. Enter a valid amount.");
        }
    }

    private void handleCheckBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", account.getBalance());
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial balance setup
        System.out.print("Enter initial balance for your account: ₹");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);
        atm.start();

        scanner.close();
    }
}
/*Enter initial balance for your account: ₹5000

=== ATM Menu ===
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option: 1
Enter amount to withdraw: ₹2000
✅ Withdrawal successful. Please collect your cash.

=== ATM Menu ===
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Choose an option: 3
💰 Current Balance: ₹3000.00
 */