public class Bank_domain {
    private final String CanaraBank = "https://www.canarabank.com/";
    private final String sbiBank ="https://www.sbibank.com/";
    private final String IndianBank ="https://www.indianbank.com/";
    private final String ICICIBank ="https://www.icicibank.com/";
    private final String IndianOverseasBank ="https://www.indianoverseasbank.com/";

    public boolean check(String bank){
        switch (bank) {
            case CanaraBank -> System.out.println("WELCOME TO CANARA BANK ");
            case sbiBank -> System.out.println("WELCOME TO SBI BANK");
            case IndianBank -> System.out.println("WELCOME TO INDIAN BANK");
            case ICICIBank -> System.out.println("WELCOME TO ICICI BANK");
            case IndianOverseasBank -> System.out.println("WELCOME TO INDIAN OVERSEAS BANK");
            default -> {
                System.out.println("ERROR 404") ;
                return false;
            }
        }
        return true;
    }
}
