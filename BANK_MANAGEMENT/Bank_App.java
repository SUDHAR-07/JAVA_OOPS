import java.util.ArrayList;
import java.util.Scanner;

public class Bank_App {
    ArrayList<Customer> customers = new ArrayList<>();
    public static int nextUserId = 1;
    Scanner susan = new Scanner(System.in);
    public void start(){
        boolean bankUrl = false;
        while (!bankUrl) {
            String bank = getURL("ENTER URL");
            Bank_domain bankDomain = new Bank_domain();
            bankUrl = bankDomain.check(bank);
        }
        boolean flag = true;
        while (flag){
            print("1. CREATE ACCOUNT\n2. SIGN IN\n3. EXIT");
            int n = getIntInput("Choose any one ",3);
            if(n == 1){
                Customer customer = createCustomer();
                customers.add(customer);
                Bank bank = Bank.getInstance();
                bank.addCustomer(customer);
                System.out.println(customers);
            } else if (n == 2) {
                Customer customer = getCustomers("LOGIN PAGE");
            } else if (n == 3) {
                flag = false;
            }
        }
    }
    public Customer createCustomer(){
        System.out.println("WELCOME");
        String userName = getString("ENTER NAME ");
        String userGmail = getUserGMAIL("ENTER GMAIL ");
        int userId = nextUserId++;
        long mobileNo = getMobileNo("ENTER MOBILE NO ");
        String address = getString("ENTER ADDRESS");
        int InitialAmount = getInput(("YOU NEED TO DEPOSIT MIN 500 to Create account\n"));
        return new Customer(userName,userGmail,userId,mobileNo,address,InitialAmount);
    }
    public Customer getCustomers(String prompt) {
        boolean flag = true;
        Customer customer = null;
        while (flag) {
            System.out.println(prompt);
            String userName = getUserGMAIL("Please enter your gmail");
            System.out.println("ENTER CUSTOMER ID");
            int customerId = susan.nextInt();
            susan.nextLine();
            customer = Customer.getById(customerId, userName);
            if (customer == null) {
                print("USER ID or USERNAME is incorrect");
            }else {
                print("LOGIN SUCCESSFULLY !!!! \nSELECT WHAT WE CAN DO FOR YOU NOW ");
                bankOperations(customer);
                flag = false;
            }
        }
        return customer;
    }
    public void bankOperations(Customer customer){
        Bank bank = Bank.getInstance();
        boolean flag = true;
        while (flag){
            print("1. CHECK BALANCE \n2. CREDIT MONEY \n3. DEBIT MONEY");
            print("4. SEND MONEY\n5. Print CHECKBOOK\n6. EXIT\n");
            int n = getIntInput("Choose any one ",6);
            if(n == 1){
                System.out.println("ACC BALANCE " + customer.getAccountBalance());
                print("ACC BALANCE " + bank.getBalance(customer));
            } else if (n == 2) {
                double money = getMoney("ENTER MONEY TO CREDIT TO YOUR ACC");
                bank.addMoney(customer,money);
                System.out.println("NEW ACC BALANCE is " + bank.getBalance(customer));
            } else if (n == 3) {
                double money = getMoney("ENTER MONEY TO DEBIT TO YOUR ACC");
                bank.debitMoney(customer,money);
                System.out.println("NEW ACC BALANCE is " + bank.getBalance(customer));
            } else if (n == 4) {
                long accNo = getMobileNo("ENTER ACCOUNT NO U NEED TO PAY ");
                double money = getMoney("ENTER AMOUNT TO SEND ");
                bank.sendMoney(customer,accNo,money);
            } else if (n == 5) {
                bank.printCheckBook(customer);
            } else if (n == 6) {
                flag = false;
            }
        }
    }
    public int getIntInput(String prompt,int value) {
        int input = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(susan.nextLine());
                if(input > 0 && input <= value) {
                    validInput = true;
                }else{
                    System.out.println("No option available choose correct option");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return input;
    }

    public String getURL(String prompt){
        String bank ="";
        boolean valid = false;
        do {
            System.out.println(prompt);
            try {
                bank = susan.nextLine();
                if (bank.matches("[a-zA-Z:/.]+$")) {
                    valid = true;
                }else {
                    System.out.println("ENTER CORRECT URL ");
                }
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
        }while (!valid);
        return bank;
    }
    public int getInput(String prompt){
        int input = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt);
            System.out.println("ENTER THE AMOUNT U NEED TO DEPOSIT");
            try {
                input = Integer.parseInt(susan.nextLine());
                if(input < 500){
                    System.out.println("ENTER AMOUNT minimum 500");
                }else{
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        return input;
    }
    public String getString(String prompt){
        String address ="";
        boolean valid = false;
        do {
            System.out.println(prompt);
            try {
                address = susan.nextLine();
                valid = true;
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
        }while (!valid);
        return address;
    }
    public double getMoney(String prompt){
        double g = 0;
        boolean valid = false;
        do{
            System.out.println(prompt);
            try {
                String temp = susan.next();
                g = Double.parseDouble(temp);
                susan.nextLine();
                valid = true;
            }catch (Exception e){
                System.out.println("error enter again " + e.getMessage());
            }
        }while(!valid);
        return g;
    }
    public long getMobileNo(String mobile){
        long g = 0;
        boolean valid = false;
        do{
            System.out.println(mobile);
            try {
                String temp = susan.next();
                g = Long.parseLong(temp);
                if(temp.length() == 10){
                    valid = true;
                    susan.nextLine();
                }else {
                    System.out.println("INPUT should be 10 digits");
                }
            }catch (Exception e){
                System.out.println("error enter again " + e.getMessage());
            }
        }while(!valid);
        return g;
    }
    public void print(String prompt){
        System.out.println(prompt);
    }

    public String getUserGMAIL(String prompt){
        String userName ="";
        boolean valid = false;
        do {
            System.out.println(prompt);
            try {
                userName= susan.nextLine();
                if (userName.matches("[a-zA-Z1-9@.]+$")) {
                    valid = true;
                }else {
                    System.out.println("ENTER CORRECT GMAIL ");
                }
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
            }
        }while (!valid);
        return userName;
    }



    public static void main(String[] args) {
        Bank_App start = new Bank_App();
        start.start();
    }
}
