package homework_4.cars.model;

import com.roman.lis.hw.homework3.cars.model.enums.*;

import java.util.Set;

public class SUV extends Car {
    private final byte numSeats;

    public SUV(Model model, EngineVolume engineVolume, Color color, WheelSize wheelSize, Set<Option> options, byte numSeats) {
        super(numSeats, model, engineVolume, color, wheelSize, options);
        this.numSeats = numSeats;
    }

    public byte getNumSeats() {
        return numSeats;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of seats: " + numSeats);
    }
}
