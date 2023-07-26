public class Product{
  private int productID;
  private String productName;

  public Product(int productID,String productName){
    this.productID = productID;
    this.productName = productName;
  }
  public int getProductId(){
    return productID;
  }

  public String getProductName(){
    return productName;
  }
}