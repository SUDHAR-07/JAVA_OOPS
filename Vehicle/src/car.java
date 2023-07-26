import java.util.ArrayList;

public class car extends Vehicle {

    private int trunkCapacity;

    private boolean isConvertible;

    public car(String vehicle_name, int speed, String motor_Description, int max_power, int no_of_seats, int no_of_doors, String color, int production_year, ArrayList<String> accessories, ArrayList<String> extras, int trunkCapacity, boolean isConvertible) {
        super(vehicle_name, speed, motor_Description, max_power, no_of_seats, no_of_doors, color, production_year, accessories, extras);
        this.trunkCapacity = trunkCapacity;
        this.isConvertible = isConvertible;
    }

    @Override
    public void increaseSpeed(double amount){
        super.increaseSpeed(amount);
    }

    @Override
    public void decreaseSpeed(double amount){
        super.decreaseSpeed(amount);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CAR Details:\n");
        sb.append("Speed: ").append(getSpeed()).append(" km/h\n");
        sb.append("Motor Description: ").append(getMotor_Description()).append("\n");
        sb.append("Max Power: ").append(getMax_power()).append(" HP\n");
        sb.append("Number of Seats: ").append(getNo_of_seats()).append("\n");
        sb.append("Number of Doors: ").append(getNo_of_doors()).append("\n");
        sb.append("Color: ").append(getColor()).append("\n");
        sb.append("Production Year: ").append(getProduction_year()).append("\n");
        sb.append("Accessories: ").append(getAccessories()).append("\n");
        sb.append("Extras: ").append(getExtras()).append("\n");
        return sb.toString();
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(int trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    public boolean isConvertible() {
        return isConvertible;
    }

    public void setConvertible(boolean convertible) {
        isConvertible = convertible;
    }
}
