public class Main {
  public static void main(String[] args) {
  
    Circle cir = new Circle(5.0,"RED");
    Triangle tri = new Triangle(5,12,"GREEN");
    System.out.println("Triangle Color: " + tri.getColor());
    System.out.println("Triangle Area: " + tri.getArea());
    System.out.println("BASE  " + tri.getBase());
    
    cir.setRadius(2.0);
    System.out.println("CIRCLE COLOR " + cir.getColor());
    System.out.println("CIRCLE AREA " + cir.getArea());
    System.out.println("CIRCLE RADIUS " + cir.getRadius());
  }
}
