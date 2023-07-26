import java.util.ArrayList;

 public class Vehicle implements speed{

     private String vehicle_name;
     private int speed;
     private String motor_Description;
     private int max_power;
     private int no_of_seats;
     private int no_of_doors;
     private String color;
     private int production_year;

     ArrayList<String> Accessories = new ArrayList<>();
     ArrayList<String> Extras = new ArrayList<>();


     public Vehicle(String vehicle_name, int speed, String motor_Description, int max_power, int no_of_seats, int no_of_doors, String color, int production_year, ArrayList<String> accessories, ArrayList<String> extras) {
         this.vehicle_name = vehicle_name;
         this.speed = speed;
         this.motor_Description = motor_Description;
         this.max_power = max_power;
         this.no_of_seats = no_of_seats;
         this.no_of_doors = no_of_doors;
         this.color = color;
         this.production_year = production_year;
         Accessories = accessories;
         Extras = extras;
     }

     @Override
     public void increaseSpeed(double amount){
         speed += amount;
     }
     @Override
     public void decreaseSpeed(double amount){
         speed -= amount;
     }


     public ArrayList<String> getAccessories() {
         return Accessories;
     }

     public void setAccessories(ArrayList<String> accessories) {
         Accessories = accessories;
     }

     public ArrayList<String> getExtras() {
         return Extras;
     }

     public void setExtras(ArrayList<String> extras) {
         Extras = extras;
     }

     public String getVehicle_name() {
         return vehicle_name;
     }

     public void setVehicle_name(String vehicle_name) {
         this.vehicle_name = vehicle_name;
     }

     public int getSpeed() {
        return speed;
    }

    public String getMotor_Description() {
        return motor_Description;
    }

    public int getMax_power() {
        return max_power;
    }

    public int getNo_of_seats() {
        return no_of_seats;
    }

    public int getNo_of_doors() {
        return no_of_doors;
    }

    public String getColor() {
        return color;
    }

    public int getProduction_year() {
        return production_year;
    }


     public void setSpeed(int speed) {
         this.speed = speed;
     }

     public void setMotor_Description(String motor_Description) {
         this.motor_Description = motor_Description;
     }

     public void setMax_power(int max_power) {
         this.max_power = max_power;
     }

     public void setNo_of_seats(int no_of_seats) {
         this.no_of_seats = no_of_seats;
     }

     public void setNo_of_doors(int no_of_doors) {
         this.no_of_doors = no_of_doors;
     }

     public void setColor(String color) {
         this.color = color;
     }

     public void setProduction_year(int production_year) {
         this.production_year = production_year;
     }
}
