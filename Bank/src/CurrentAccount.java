public class CurrentAccount extends Account {
    // CurrentAccount class

        public CurrentAccount(Customer customer, String accountNumber) throws InvalidCustomerException {
            super(customer, accountNumber);
        }

        @Override
        public void displayDetails() {
            System.out.println("Account Type: Current Account");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
            customer.displayDetails();
        }

}
