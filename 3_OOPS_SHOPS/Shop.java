// import java.util.HashMap;
import java.util.*;

public class Shop {
  private int shopId;
  private String shopName;
  private Map<Integer,Integer> stock;

  public Shop(int shopId,String shopName){
    this.shopId = shopId;
    this.shopName = shopName;
    this.stock = new HashMap<>();
  }
  public int getShopId(){
    return shopId;
  }
  public String getShopName(){
    return shopName;
  }
  public void addStock(int productId,int quantity){
    stock.put(productId, quantity);
  }

  public int getStockQuantity(int productId){
    return stock.getOrDefault(productId, 0);
  }

  public Map<Integer, Integer> getStock() { 
    return stock;
  }
}
