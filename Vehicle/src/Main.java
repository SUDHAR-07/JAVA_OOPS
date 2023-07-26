import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> accessories = new ArrayList<>();
        ArrayList<String> extras = new ArrayList<>();
        accessories.add("Riding adventure cap");
        accessories.add("RE headgear");
        accessories.add("Face mask");
        extras.add("hand");
        extras.add("gear");
        extras.add("wire");
        MotorBike bike = new MotorBike("RoyalEnfield",150,"346 CC ENGINE",6100,2,0,"Blue",2002,accessories,extras,0,false);
        System.out.println("speed " + bike.getSpeed());
        bike.increaseSpeed(50);
        System.out.println("speed increased " + bike.getSpeed());
        Truck truck = new Truck("BEN10",180,"120 CC",200,2,3,"RED",1999,accessories,extras,true);
        System.out.println(truck.getSpeed() + " ==  truck speed");
        car Car = new car("swift",250,"FINE",250,4,4,"GREEN",2013,accessories,extras,0,false);

        System.out.println(Car.getColor());
        System.out.println(Car);
        System.out.println(bike);
        System.out.println(truck);

    }
}