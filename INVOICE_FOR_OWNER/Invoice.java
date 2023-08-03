import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Invoice {
    private final Customer_Details customer;
    private final int invoiceId;
    private final String shopName;
    private final LocalDate date;
    private final LocalTime time;
    private final ArrayList<ItemOrder> itemOrders;
    private final double subTotal;
    private final double Taxes;
    private final double grandTotal;
    private final int finalDiscount;

    public Invoice(Customer_Details customer, int invoiceId, String shopName, LocalDate date, LocalTime time, String place, ArrayList<ItemOrder> itemOrders, double subTotal, double taxes, double roundOff, double grandTotal, int finalDiscount) {
        this.customer = customer;
        this.invoiceId = invoiceId;
        this.shopName = shopName;
        this.date = date;
        this.time = time;
        this.itemOrders = itemOrders;
        this.subTotal = subTotal;
        this.Taxes = taxes;
        this.grandTotal = grandTotal;
        this.finalDiscount = finalDiscount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        sb.append(" ----------------------------------MY SHOP NAME : ").append(shopName).append("--------------------------\n");
        sb.append(" DATE : ").append(date).append("   Time   ").append(time).append("\n");
        sb.append(" Invoice id : ").append(invoiceId).append("\n");
        sb.append("Customer Name: ").append(customer.getCustomerName()).append(", Customer ID: ").append(customer.getCustomerId()).append("\n");

        // Display details of each item order
        sb.append("ITEM DETAILS - QUANTITY - PRICE - RATE - DISCOUNT - TAXES - AMOUNT\n");
        for (int i = 0; i < itemOrders.size(); i++) {
            sb.append(i + 1).append(") ").append(itemOrders.get(i)).append("\n");
        }

        sb.append("SUB TOTAL ").append(df.format(subTotal)).append(" \n");
        sb.append("TAXES ").append(df.format(Taxes)).append(", Final discount ").append(finalDiscount).append("% \n");
        sb.append("GRAND TOTAL ").append(Math.round(grandTotal)).append("\n");
        sb.append("THANK YOU!\n");
        return sb.toString();
    }
}
