//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Customer customer1 = new Customer("Alice", "C001");
            Customer customer2 = new Customer("", "C002"); // Invalid customer

            // Valid Current Account
            CurrentAccount currentAccount = new CurrentAccount(customer1, "CA1001");
            currentAccount.credit(5000);
            currentAccount.debit(2000);
            currentAccount.displayDetails();

            System.out.println("---------------");

            // Valid Savings Account
            SavingsAccount savingsAccount = new SavingsAccount(customer1, "SA2001", 1500);
            savingsAccount.credit(1000);
            savingsAccount.debit(500);
            savingsAccount.displayDetails();

            System.out.println("---------------");

            // Invalid customer for Current Account
            CurrentAccount invalidAccount = new CurrentAccount(customer2, "CA1002");

        } catch (InvalidCustomerException | InvalidAmountException | InsufficientFundsException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}