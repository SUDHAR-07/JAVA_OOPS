public class Item {
    private String itemName;
    private int itemId;
    private int availableQuantity;
    private int quantity;
    private double markedPrice;
    private double sellingPrice;
    private double gain = 0;
    private double loss = 0;

    public Item(String itemName,int itemId,int quantity,double markedPrice){
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.availableQuantity = quantity;
        this.markedPrice = markedPrice;
    }
    public void reduceAvailableQuantity(int quantity){
        availableQuantity -= quantity;
    }
    public void calculate_gain_or_loss(Item item){
        if(item.getMarkedPrice() < item.getSellingPrice()){
            gain = item.getSellingPrice() - item.getMarkedPrice();
        }else{
            loss = item.getMarkedPrice() - item.getSellingPrice();
        }
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMarkedPrice() {
        return markedPrice;
    }

    public void setMarkedPrice(double markedPrice) {
        this.markedPrice = markedPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }

    public double getLoss() {
        return loss;
    }

    public void setLoss(double loss) {
        this.loss = loss;
    }
}
