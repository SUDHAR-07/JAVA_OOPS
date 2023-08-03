import java.util.ArrayList;
import java.util.HashMap;

public class Customer_Details {
    private static int nextCustomerId = 1;
    private int customerId;
    private String customerName;
    public static HashMap<String,Customer_Details> CustomerMapping = new HashMap<>();
    public static HashMap<Integer,Customer_Details> customerIdMapping = new HashMap<>();
    private final ArrayList<Invoice> invoices = new ArrayList<>();
    public Customer_Details(String customerName){
        this.customerName = customerName;
        this.customerId = nextCustomerId++;
        CustomerMapping.put(customerName,this);
        customerIdMapping.put(customerId,this);
    }
    public static Customer_Details getByValue(String customerName){
        return CustomerMapping.get(customerName);
    }
    public static Customer_Details getByID(int customerId){
        return customerIdMapping.get(customerId);
    }
    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
    public ArrayList<Invoice> getInvoices(){
        return invoices;
    }
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
