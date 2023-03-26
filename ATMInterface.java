import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userId = 1234; // Sample user ID
        int userPin = 4321; // Sample user PIN

        System.out.print("Enter user ID: ");
        int inputId = sc.nextInt();

        System.out.print("Enter user PIN: ");
        int inputPin = sc.nextInt();

        if (inputId != userId || inputPin != userPin) {
            System.out.println("Invalid ID or PIN. Please try again.");
            return;
        }

        ATM atm = new ATM();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.showTransactionsHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = sc.nextDouble();
                    System.out.print("Enter receiver's account number: ");
                    int receiverAccountNumber = sc.nextInt();
                    atm.transfer(transferAmount, receiverAccountNumber);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM. Goodbye!");
    }
}

class ATM {
    private double balance;
    private String transactionsHistory;

    public ATM() {
        balance = 0;
        transactionsHistory = "";
    }

    public void showTransactionsHistory() {
        System.out.println("Transactions History:");
        System.out.println(transactionsHistory);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        transactionsHistory += "Withdraw: $" + amount + "\n";
        System.out.println("Withdraw successful.");
    }

    public void deposit(double amount) {
        balance += amount;
        transactionsHistory += "Deposit: $" + amount + "\n";
        System.out.println("Deposit successful.");
    }

    public void transfer(double amount, int receiverAccountNumber) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        transactionsHistory += "Transfer: $" + amount + " to account " + receiverAccountNumber + "\n";
        System.out.println("Transfer successful.");
    }
}
