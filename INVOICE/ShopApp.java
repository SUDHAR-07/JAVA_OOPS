import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShopApp {
    public static int invoiceId_count = 1;
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Invoice> invoices = new ArrayList<>();

    Scanner susan = new Scanner(System.in);
    public void execute(){
        storeProduct();
        boolean ch = true;
        while (ch) {
            Customer customer = getCustomer();
            customers.add(customer);
            Invoice invoice = createInvoice(customer);
            if(invoice != null) {
                customer.addInvoice(invoice);
                System.out.println("INVOICE :");
                System.out.println(invoice);
            }
            System.out.println("SHOP AGAIN (Y or N)");
            susan.nextLine();
            String a = susan.nextLine();
            if(a.equals("N")){
                ch = false;
            }
        }
        getMethod();
    }
    public void printFinal(){
        System.out.println("1.GET INVOICE BY INVOICE ID");
        System.out.println("2.GET LIST OF INVOICE OF PARTICULAR CUSTOMER BY CUSTOMER ID");
    }
    public void getInvoicesByID(int invoiceId){
        for(Invoice invoice : invoices){
            if(invoice.getInvoiceId() == invoiceId){
                System.out.println("INVOICE : ");
                System.out.println(invoice);
                return;
            }
        }
        System.out.println("Invoice with ID " + invoiceId + " not found.");
    }
    public void getInvoicesByCustId(int custId){
        for(Customer customer : customers){
            if(customer.getCustomerId() == custId){
                if(customer.getInvoices().isEmpty()){
                    System.out.println("CUSTOMER HAS NO INVOICES");
                }else{
                    System.out.println("--------INVOICES-------");
                    for(Invoice inv : customer.getInvoices()){
                        System.out.println(inv);
                    }
                }
                System.out.println("---------END--------");
                break;
            }
        }

    }
    public void getMethod(){
        boolean ch = true;
        while (ch){
            printFinal();
            System.out.println("SELECT AN OPTION (1 or 2");
            int n = susan.nextInt();
            if(n == 1){
                System.out.println("ENTER INVOICES ID");
                int invoiceId = susan.nextInt();
                susan.nextLine(); // Consume the newline character
                getInvoicesByID(invoiceId);
            }else if(n == 2){
                System.out.println("ENTER CUSTOMER ID");
                int custId = susan.nextInt();
                susan.nextLine();
                getInvoicesByCustId(custId);
            }else{
                System.out.println("ENTER CORRECT INPUT");
                continue;
            }
            System.out.println("ENTER Y/N ");
            String a = susan.nextLine();
            if(a.equals("N")){
                System.out.println("THANK-YOU");
                ch = false;
            }
        }
    }

    public Invoice createInvoice(Customer customer) {
        System.out.println("Select items you want to purchase (Enter item number, 0 to finish):");
        int invoiceId = invoiceId_count;
        String place = "Madurai";
        String shopName="Sports";
        LocalDate date = LocalDate.now();
        int actualPrice = 0, markedPrice = 0, totalPrice = 0, discountPrice = 0, soldPrice, taxes, finalPrice = 0;
        // ArrayList to store the selected items for the invoice
        ArrayList<Item> selectedItems = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        boolean flag = true,flag1 = false;
        while (flag) {

            print();
            int n = susan.nextInt();
            if (n >= 1 && n <= items.size()) {
                flag1 = true;
                Item selectedItem = items.get(n - 1);
                System.out.println("Enter the quantity for " + selectedItem.getItem() + ":");
                int quantity = susan.nextInt();
                if (quantity <= selectedItem.getAvailableQuantity()) {
                    selectedItems.add(selectedItem);
                    quantities.add(quantity);
                    markedPrice = selectedItem.getMarkedPrice();
                    actualPrice = (int) (selectedItem.getMarkedPrice() *0.9);
                    selectedItem.setSellingPrice(actualPrice);
                    totalPrice += (actualPrice * quantity);
                    selectedItem.reduceAvailableQuantity(quantity); // Reduce the available quantity in stock
                } else {
                    System.out.println("Insufficient quantity in stock for " + selectedItem.getItem());
                }
            } else if (n == 0) {
                flag = false;
            } else {
                System.out.println("Invalid item number. Please try again.");
            }
        }
        if(totalPrice > 10000){
            discountPrice = (int)(totalPrice * 0.1);
            soldPrice = totalPrice - discountPrice;
            taxes = (int)(totalPrice * (0.15));
            finalPrice = totalPrice + taxes;
        }else {
            soldPrice = totalPrice;
            taxes = (int) (totalPrice * (0.13));
            finalPrice = totalPrice + taxes;
        }
        if(flag1){
            invoiceId_count++;
            Invoice invoice = new Invoice(customer, invoiceId, date, place, shopName, selectedItems, quantities,
                    actualPrice, markedPrice, totalPrice, discountPrice, soldPrice, taxes, finalPrice);
            invoices.add(invoice);
            return invoice;
        }else{
            return null;
        }

    }

    public void print() {
        int n = 1;
        System.out.println("Available Items:");
        for (Item item : items) {
            System.out.println( n++ + ")" + item.getItem() +
                    ", Quantity: " + item.getItemQuantity() +
                    ", Price: " + item.getMarkedPrice());
        }
    }

    public Customer getCustomer(){
        System.out.println("Enter customer name");
        String customer=susan.nextLine();
        Customer customer1 = Customer.getByValue(customer);
        if(customer1 == null){
            Customer customer2 = new Customer(customer);
            System.out.println("CUSTOMER NAME " + customer2.getCustomerName() + " ID " + customer2.getCustomerId());
            return customer2;
        }else {
            System.out.println("CUSTOMER NAME " + customer1.getCustomerName() + " ID " + customer1.getCustomerId());
            return customer1;
        }
    }
    public void storeProduct(){
        Item item1 = new Item("bat",1,100,1000);
        Item item2 = new Item("ball",2,200,50);
        Item item3 = new Item("gloves",3,300,150);
        Item item4 = new Item("kit",4,400,200);
        items.addAll(Arrays.asList(item1, item2, item3, item4));
    }

    public static void main(String[] args) {
        ShopApp start = new ShopApp();
        start.execute();
    }
}
