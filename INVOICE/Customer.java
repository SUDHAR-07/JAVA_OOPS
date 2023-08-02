import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    public String CustomerName;
    public int customerId;
    private static int nextCustomerId = 1;
    private final ArrayList<Invoice> invoices = new ArrayList<>();
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }
    public static HashMap<String,Customer> customerMap = new HashMap<>();
    public Customer(String customerName){
        this.CustomerName = customerName;
        this.customerId = nextCustomerId++;
        customerMap.put(customerName,this);
    }

    public static Customer getByValue(String name) {
        for (Customer customer : customerMap.values()) {
            if (customer.getCustomerName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


}
