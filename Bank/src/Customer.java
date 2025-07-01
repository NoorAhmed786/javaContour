public class Customer {

        private String name;
        private String customerId;

        public Customer(String name, String customerId) {
            this.name = name;
            this.customerId = customerId;
        }

        public boolean isValid() {
            return name != null && !name.trim().isEmpty() && customerId != null && !customerId.trim().isEmpty();
        }

        public void displayDetails() {
            System.out.println("Customer ID: " + customerId);
            System.out.println("Customer Name: " + name);
        }

}
