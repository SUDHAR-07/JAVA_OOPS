import java.util.ArrayList;
import java.util.List;

public class Stock {
  private List<Shop> shops;

  public Stock(){
    this.shops = new ArrayList<>();
  }
  public void addshop(Shop shop){
    shops.add(shop);
  }

  public List<Shop> getShops(){
    return shops;
  }
}
