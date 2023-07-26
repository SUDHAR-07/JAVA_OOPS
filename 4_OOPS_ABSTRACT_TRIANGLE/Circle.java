import java.util.*;

class Circle extends Shape{

  private double radius;
  //constructor  - called when instance are created

  public Circle(double radius,String color) {
    super(color);
    this.radius = radius;
  }

  public void setRadius(double radius){
    this.radius = radius;
  }
  public double getRadius(){
    return radius;
  }

  @Override 
  public double getArea(){
    return Math.PI * radius * radius;
  }
}

