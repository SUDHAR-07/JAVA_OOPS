import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private long nextAccountNo = 1111111111;
    private int customerId;
    private final String customerName;
    private final String customerGmail;
    private final int iffcCode = 1250;
//    private int cifId;
    private ArrayList<String> transactions = new ArrayList<>();
    private long accountNo;
    private double accountBalance;
    private long mobileNo;
    private String address;
    private static final HashMap<Integer,Customer> customerMapping = new HashMap<>();
    private static final HashMap<Long,Customer> AccountMapping = new HashMap<>();
    public Customer(String customerName,String customerGmail,int customerId,long mobileNo,String address,int accountBalance){
        this.customerName = customerName;
        this.customerGmail = customerGmail;
        this.customerId = customerId;
        this.mobileNo = mobileNo;
        this.address = address;
        this.accountNo = nextAccountNo++;
        this.accountBalance = accountBalance;
        transactions.add("ACC started with  "+ accountBalance + " customer name" + customerName);
        customerMapping.put(customerId,this);
        AccountMapping.put(accountNo,this);
    }

    public static Customer getByAcc(long accountNo){
        return AccountMapping.get(accountNo);
    }
    public static Customer getById(int customerId,String customerGmail){
        boolean value = customerMapping.get(customerId).customerGmail.equals(customerGmail);
        if(value){
            return customerMapping.get(customerId);
        }
        return null;
    }

    public void printCheckBook(){
        for(int i = 0; i< transactions.size();i++){
            System.out.println(transactions.get(i));
        }
    }

    @Override
    public String toString(){
        return "CUSTOMER ID " + customerId + "  CUSTOMER NAME " + customerName + "\n" +
                "ACCOUNT NO " + accountNo + "  ACCOUNT BALANCE " + accountBalance + "\n" +
                "GMAIL " + customerGmail + " MOBILE NO " + mobileNo + " ADDRESS " + address;
    }

    public void addBalance(double money,String customerName){
        transactions.add("ACC credit with  "+ money + " by " + customerName);
        this.accountBalance += money;
    }
    public void debitMoney(double money,String customerName){
        transactions.add("ACC debited with " + money + " to " + customerName);
        this.accountBalance -= money;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getIffcCode() {
        return iffcCode;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}