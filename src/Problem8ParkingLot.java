import java.util.*;

public class Problem8ParkingLot {

    String[] parking;
    int size = 10;

    public Problem8ParkingLot() {
        parking = new String[size];
    }

    private int hash(String plate) {
        return Math.abs(plate.hashCode()) % size;
    }

    public void parkVehicle(String plate) {

        int index = hash(plate);

        while (parking[index] != null) {
            index = (index + 1) % size;
        }

        parking[index] = plate;

        System.out.println("Vehicle parked at " + index);
    }

    public static void main(String[] args) {

        Problem8ParkingLot lot = new Problem8ParkingLot();

        lot.parkVehicle("ABC123");
        lot.parkVehicle("XYZ999");
    }
}