abstract class Account {

    protected Customer customer;
    protected double balance;
    protected String accountNumber;

    public Account(Customer customer, String accountNumber) throws InvalidCustomerException {
        if (customer == null || !customer.isValid()) {
            throw new InvalidCustomerException("Invalid customer provided.");
        }
        this.customer = customer;
        this.accountNumber = accountNumber;
    }

    public void credit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero.");
        }
        balance += amount;
        System.out.println("Credited " + amount + ". New Balance: " + balance);
    }

    public void debit(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Current Balance: " + balance);
        }
        balance -= amount;
        System.out.println("Debited " + amount + ". New Balance: " + balance);
    }

    public abstract void displayDetails();
}



