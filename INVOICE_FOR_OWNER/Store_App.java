import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Store_App {
    private static int invoiceId_count = 1;
    ArrayList<Customer_Details> customerDetails = new ArrayList<>();
    ArrayList<Invoice> invoices = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    Scanner susan = new Scanner(System.in);
    public int getIntInput(String prompt) {
        int input = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(susan.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return input;
    }
    public String getString(String prompt){
        String input;
        boolean validInput = false;
        do{
            System.out.println(prompt);
            input = susan.nextLine();
            if(input.matches("[a-zA-Z]+")){
                validInput = true;
            }else{
                System.out.println("INVALID INPUT PLEASE ENTER AGAIN ");
            }
        }while (!validInput);
        return input;
    }
    public void run(){
        boolean flag = true;
        while (flag){
            System.out.println("1. CREATE BILL FOR CUSTOMER");
            System.out.println("2. ADD ITEMS IN SHOP");
            System.out.println("3. UPDATE STOCK BY ITEM ID");
            System.out.println("4. GET INVOICE BY INVOICE ID");
            System.out.println("5. GET LIST OF INVOICE'S OF PARTICULAR CUSTOMER BY CUSTOMER ID");
            System.out.println("6. EXIT");
            int n = getIntInput("ENTER A INTEGER (1-6)");
            switch (n){
                case 1 -> createInvoice();
                case 2 -> addItem();
                case 3 -> addStocks();
                case 4 -> invoiceById();
                case 5 -> invoicesByCustomerId();
                case 6 -> flag = false;
                default -> System.out.println("Invalid input");
            }
        }
    }
    public void addStocks(){
        int itemId = getIntInput("ENTER ITEM ID");
        for(Item item : items){
            if(item.getItemId() == itemId){
                System.out.println("ITEM NAME :" +item.getItemName() + "ITEM QUANTITY " + item.getQuantity());
                int itemQuantity = getIntInput("ENTER NEW QUANTITY");
                itemQuantity += item.getQuantity();
                item.setQuantity(itemQuantity);
            }
        }
        printItems("AFTER UPDATE");
    }
    public Customer_Details getCustomer(){
        String customerName = getString("ENTER CUSTOMER NAME ");
        if(Customer_Details.getByValue(customerName) == null){
            Customer_Details customer = new Customer_Details(customerName);
            System.out.println("CUSTOMER NAME " + customer.getCustomerName() + " CUSTOMER ID " + customer.getCustomerId());
            return customer;
        }else{
            Customer_Details customer =  Customer_Details.getByValue(customerName);
            System.out.println("ALREADY CUSTOMER with CUSTOMER NAME " + customer.getCustomerName() + " CUSTOMER ID " + customer.getCustomerId());
            return customer;
        }
    }
    public void createInvoice(){
        Customer_Details customer = getCustomer();
        customerDetails.add(customer);
        int invoiceId = invoiceId_count;
        double finalTax,grandTotal,finalDiscount;
        String place = "Madurai",shopName = "Sports";
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        ArrayList<ItemOrder> itemOrders = new ArrayList<>();
        boolean flag = true,invoiceNeed = false;
        while (flag) {
            printItems("AVAILABLE ITEMS ");
            int selectItem = getIntInput("SELECT ITEM YOU WANT TO PURCHASE 1 to " + items.size() + " 0 to FINISH");
            if(selectItem >= 1 && selectItem <= items.size()){
                Item selectedItem = items.get(selectItem - 1);
                int quantity = getIntInput("ENTER QUANTITY for " + selectedItem.getItemName() + ":");
                if(quantity <= selectedItem.getAvailableQuantity()){
                    invoiceNeed = true;
                    printItemById(selectedItem.getItemId());
                    int getPrice = getIntInput("ENTER SELLING PRICE ");
                    int getDiscount = getIntInput("ENTER DISCOUNT % YOU WANT TO GIVE FOR THIS ITEM");
                    int taxes = getIntInput("Enter tax % for this item");
                    ItemOrder itemOrder = new ItemOrder(selectedItem,quantity,getPrice,getDiscount,taxes);
                    itemOrders.add(itemOrder);
                    selectedItem.reduceAvailableQuantity(quantity);
                    selectedItem.calculate_gain_or_loss(selectedItem);
                }else {
                    System.out.println("Insufficient quantity in stock for " + selectedItem.getItemName());
                }
            } else if (selectItem == 0) {
                flag = false;
            } else{
                System.out.println("INVALID INPUT PLEASE TRY AGAIN");
            }
        }
        if(invoiceNeed){
//            double subtotal = itemOrders.stream().mapToDouble(ItemOrder::getAmount).sum();
            double subtotal = 0;
            for (ItemOrder itemOrder : itemOrders) {
                subtotal += itemOrder.getAmount();
            }

            System.out.println("THE TOTAL PURCHASE IS " + subtotal);
            finalTax = getIntInput("DID YOU LIKE TO ADD FINAL TAX %");
            finalDiscount = getIntInput("DID YOU LIKE TO GIVE DISCOUNT %");
            grandTotal = subtotal - (subtotal * (finalDiscount / 100.0));
            grandTotal += (subtotal * (finalTax / 100.0));
            invoiceId_count++;

            // Create the Invoice object using itemOrders ArrayList
            Invoice invoice = new Invoice(customer, invoiceId, shopName, date, time, place, itemOrders, subtotal, finalTax, 0, grandTotal, (int) finalDiscount);
            invoices.add(invoice);
            customer.addInvoice(invoice);
            System.out.println("INVOICE ");
            System.out.println(invoice);
        } else {
            System.out.println("NO INVOICE GENERATED");
        }
    }

    public void printItemById(int itemId){
        for(Item item : items){
            if(item.getItemId() == itemId){
                System.out.println("ITEM NAME " + item.getItemName() + " ITEM MARKED PRICE " + item.getMarkedPrice());
            }
        }
    }
    public void addItem(){
//        Item item = new Item("bat",1,100,1000);
        System.out.print("Want to add how many items");
        int itemCount = susan.nextInt();
        susan.nextLine();
        for(int i = 0; i < itemCount;i++){
            System.out.println("ENTER ITEM " + (i+1));
            System.out.print("Enter item name");
            String itemName = susan.next();
            System.out.print("Enter item id");
            int itemId = susan.nextInt();
            System.out.print("Enter item quantity");
            int itemQuantity = susan.nextInt();
            System.out.print("Enter item price");
            double itemPrice = susan.nextDouble();
            Item item1 = new Item(itemName,itemId,itemQuantity,itemPrice);
            items.add(item1);
        }
        printItems("THE ADDED ITEMS ADDED SUCCESSFULLY");
        susan.nextLine();
    }
    public void printItems(String prompt){
        System.out.println(prompt);
        int i = 1;
        for(Item item : items){
            System.out.println(i++ +".) ITEM NAME : " +item.getItemName().toUpperCase() + " ITEM ID : " + item.getItemId() + " ITEM QUANTITY  :" + item.getAvailableQuantity() + " ITEM PRICE : " + item.getMarkedPrice());
        }
    }
    public void invoiceById(){
        int invoiceId = getIntInput("ENTER INVOICE ID ");
        boolean found = false;
        for(Invoice invoice : invoices){
            if(invoice.getInvoiceId() == invoiceId){
                System.out.println(invoice);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("NO INVOICES AVAILABLE FOR THIS ID ");
        }
    }
    public void invoicesByCustomerId(){
        int customerId = getIntInput("ENTER CUSTOMER ID");
        Customer_Details customer_details = Customer_Details.getByID(customerId);
        if(customer_details == null){
            System.out.println("NO CUSTOMER WITH THAT ID");
        }else{
            if(customer_details.getInvoices().isEmpty()){
                System.out.println("NO INVOICES for this customer  ");
            }else{
                System.out.println("-------------HAPPY CUSTOMER-----------");
                for(Invoice invoice : customer_details.getInvoices()){
                    System.out.println(invoice);
                }
                System.out.println("------------THANK YOU --------------");
            }
        }
    }
    public static void main(String[] args) {
        Store_App start = new Store_App();
        start.run();
    }
}
