public class ItemOrder {
    private final Item item;
    private final int quantity;
    private final double rate;
    private final int discount;
    private final int taxes;
    private double amount;

    public ItemOrder(Item item, int quantity, double rate, int discount, int taxes) {
        this.item = item;
        this.quantity = quantity;
        this.rate = rate;
        this.discount = discount;
        this.taxes = taxes;
        calculateAmount();
    }

    public double getAmount() {
        return amount;
    }
    private void calculateAmount() {
        double total = quantity * rate;
        double discountAmount = total * (discount / 100.0);
        double taxedAmount = total * (taxes / 100.0);
        this.amount = total - discountAmount + taxedAmount;
    }

    @Override
    public String toString() {
        return "Item: " + item.getItemName() +
                ", Quantity: " + quantity +
                ", Rate: " + rate +
                ", Discount: " + discount + "%" +
                ", Taxes: " + taxes + "%" +
                ", Amount: " + amount;
    }
}
