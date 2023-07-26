import java.util.*;

public class Main {
  public static void main(String[] args) {
    Product product1 = new Product(1, "Mouse");
    Product product2 = new Product(2, "Laptop");
    Product product3 = new Product(3, "Headphones");

    Shop shop1 = new Shop(101, "Electronics world");
    Shop shop2 = new Shop(102, "Gadget Maniya");

    shop1.addStock(product3.getProductId(), 400);
    shop2.addStock(product1.getProductId(), 1000);
    shop1.addStock(product2.getProductId(), 100);
    shop2.addStock(product3.getProductId(), 200);
    shop1.addStock(product1.getProductId(), 500);
    shop2.addStock(product2.getProductId(), 50);

    Stock stock = new Stock();
    stock.addshop(shop1);
    stock.addshop(shop2);

   Shop[] shops = { shop1, shop2 };

        for (Shop shop : shops) {
            System.out.println("Shop: " + shop.getShopName() + " - ID: " + shop.getShopId());
            for (int productId : shop.getStock().keySet()) {
                int quantity = shop.getStockQuantity(productId);
                System.out.println("productId  " + productId + " - Quantity: " + quantity);
            }
            System.out.println();
        }
    }
  }