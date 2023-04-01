package homework_4.cars.model;

import com.roman.lis.hw.homework3.cars.model.enums.*;

import java.util.Set;

public class Sedan extends Car {
    private final short numDoors;

    public Sedan(Model model, EngineVolume engineVolume, Color color, WheelSize wheelSize, Set<Option> options, short numDoors) {
        super(numDoors, model, engineVolume, color, wheelSize, options);
        this.numDoors = numDoors;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of doors: " + numDoors);
    }
}
