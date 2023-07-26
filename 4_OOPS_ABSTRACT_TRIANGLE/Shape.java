abstract class Shape {
  private String color;

  public Shape(String color){
    this.color = color;
  }
  public abstract double getArea();

  public void setColor(String color){
    this.color = color;
  }

  public String getColor(){
    return color;
  } 
}
