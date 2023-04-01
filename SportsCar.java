package homework_4.cars.model;

import com.roman.lis.hw.homework3.cars.model.enums.*;

import java.util.Set;

public class SportsCar extends Car {
    private final String bodyType;

    public SportsCar(Model model, EngineVolume engineVolume, Color color, WheelSize wheelSize, Set<Option> options, String bodyType) {
        super(Integer.parseInt(bodyType), model, engineVolume, color, wheelSize, options);
        this.bodyType = bodyType;
    }

    public String bodyType() {
        return bodyType;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Convertible: " + bodyType);
    }
}
