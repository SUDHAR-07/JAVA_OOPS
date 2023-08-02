public class Item {
//    public HashMap<Item,Integer> items;
    private String item;
    private int ItemId;
    private int availableQuantity;
    private int ItemQuantity;
    private int MarkedPrice;
    private int discount;
    private int SellingPrice;
    public int getAvailableQuantity() {
        return this.availableQuantity;
    }
    public void reduceAvailableQuantity(int quantity) {
        availableQuantity -= quantity;
    }
    public Item(String item,int ItemId, int ItemQuantity,int MarkedPrice){
        this.item = item;
        this.ItemId = ItemId;
        this.ItemQuantity = ItemQuantity;
        this.MarkedPrice = MarkedPrice;
        this.availableQuantity = ItemQuantity;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getItemId() {
        return ItemId;
    }
    public void setItemId(int itemId) {
        ItemId = itemId;
    }
    public int getItemQuantity() {
        return ItemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        ItemQuantity = itemQuantity;
    }
    public int getMarkedPrice() {
        return MarkedPrice;
    }
    public void setMarkedPrice(int markedPrice) {
        MarkedPrice = markedPrice;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public int getSellingPrice() {
        return SellingPrice;
    }
    public void setSellingPrice(int sellingPrice) {
        SellingPrice = sellingPrice;
    }
}
