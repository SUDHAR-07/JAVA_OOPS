import java.util.ArrayList;

public class Bank {
    private static Bank instance = new Bank();
    private Bank(){

    }
    public static Bank getInstance(){
        return instance;
    }
    private ArrayList<Customer> customers = new ArrayList<>();
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public double getBalance(Customer customer){
        return customer.getAccountBalance();
    }
    public void addMoney(Customer customer,double money){
        customer.addBalance(money,customer.getCustomerName());
    }

    public void debitMoney(Customer customer,double money){
        customer.debitMoney(money,customer.getCustomerName());
    }
    public void printCheckBook(Customer customer){
        customer.printCheckBook();
    }
    public void sendMoney(Customer customer,long accountNo,double money){
        Customer customer2 = Customer.getByAcc(accountNo);
        if(customer2== null){
            System.out.println(" NOT A VALID ACC NO");
        }else{
            System.out.println("ACCOUNT FOUND MONEY CREDITED TO " + customer2.getCustomerName());
            customer2.addBalance(money,customer.getCustomerName());
            customer.debitMoney(money,customer2.getCustomerName());
        }
    }
}
