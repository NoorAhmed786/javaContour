public class SavingsAccount extends  Account{
    // SavingsAccount class
        public SavingsAccount(Customer customer, String accountNumber, double initialDeposit)
                throws InvalidCustomerException, InvalidAmountException {
            super(customer, accountNumber);
            if (initialDeposit < 1000) {
                throw new InvalidAmountException("Initial deposit for savings account must be at least 1000.");
            }
            this.balance = initialDeposit;
        }

        @Override
        public void displayDetails() {
            System.out.println("Account Type: Savings Account");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
            customer.displayDetails();
        }

}
