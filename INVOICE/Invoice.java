import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {
    private final Customer customer;

    private final LocalDate date;
    private final String place;
    private final String shopName;
    private final ArrayList<Item> items;
    private final ArrayList<Integer> quantity;
    private final int actualPrice;
    private final int markedPrice;
    private final int totalPrice;
    private final int discountPrice;
    private final int soldPrice;
    private final int taxes;
    private final int finalPrice;
    private int invoiceId;
    public Invoice(Customer customer, int invoiceId, LocalDate date, String place, String shopName, ArrayList<Item> items,
                   ArrayList<Integer> quantity, int actualPrice, int markedPrice, int totalPrice, int discountPrice, int soldPrice, int taxes,
                   int finalPrice) {
        this.customer = customer;
        this.invoiceId = invoiceId;
        this.date = date;
        this.place = place;
        this.shopName = shopName;
        this.items = items;
        this.quantity = quantity;
        this.actualPrice = actualPrice;
        this.markedPrice = markedPrice;
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.soldPrice = soldPrice;
        this.taxes = taxes;
        this.finalPrice = finalPrice;
    }
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice ID: ").append(invoiceId).append(" ");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Customer: ").append(customer.getCustomerName()).append(" (ID: ").append(customer.getCustomerId()).append(")\n");
        sb.append("Shop: ").append(shopName).append(" ");
        sb.append("Place: ").append(place).append(" ");
        sb.append("\nItems Purchased:\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append(i + 1).append(". ").append(items.get(i).getItem());
            sb.append(", Quantity: ").append(quantity.get(i));
            sb.append(", Price: ").append(items.get(i).getSellingPrice() * quantity.get(i)).append("\n");
        }
        sb.append("\nTotal Price: ").append(totalPrice).append(" ");
        sb.append("Discount: ").append(discountPrice).append(" ");
        sb.append("Sold Price: ").append(soldPrice).append(" ");
        sb.append("Taxes: ").append(taxes).append(" ");
        sb.append("Final Price: ").append(finalPrice).append("\n");
        return sb.toString();
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
}
