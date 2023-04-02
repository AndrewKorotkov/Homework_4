package homework_4.cars.factory;

import com.roman.lis.hw.homework3.cars.model.Car;
import com.roman.lis.hw.homework3.cars.model.enums.*;
import homework_4.cars.model.Sedan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
public class SedanFactory {
    private static final int YEAR = 2023;

    private final Color[] colors;
    private final Model[] models;
    private final WheelSize[] wheelSizes;
    private final EngineVolume[] engineVolumes;
    private final short numDoors;

    private final Storage storage;

    public SedanFactory(Color[] colors, Model[] models, WheelSize[] wheelSizes, EngineVolume[] engineVolumes, short numDoors) {
        this.colors = colors;
        this.models = models;
        this.wheelSizes = wheelSizes;
        this.engineVolumes = engineVolumes;
        this.numDoors = numDoors;
        this.storage = new Storage();
        fillStorageWithCars();
    }

    public Sedan createSedan(Model model, EngineVolume engineVolume, Color color, WheelSize wheelSize, short numDoors, Set<Option> options) {
        Sedan sedan = storage.getCarFromStorage(model, engineVolume, color, wheelSize);
        if (sedan != null) {
            if (sedan.getColor() != color) {
                sedan.setColor(color);
            }
            if (sedan.getWheelSize() != wheelSize) {
                sedan.setWheelSize(wheelSize);
            }
            sedan.setOptions(options);
            return sedan;
        }
        return new Sedan(YEAR, model, engineVolume, color, wheelSize, numDoors, options);
    }

    public String getConfigurations() {
        return format(
                "Factory can produce: colors: %s, models: %s, wheelSizes: %s, engineVolumes: %s",
                Arrays.toString(colors),
                Arrays.toString(models),
                Arrays.toString(wheelSizes),
                Arrays.toString(engineVolumes),
                Arrays.toString(new short[]{numDoors})
        );
    }


    private void fillStorageWithCars() {
        Car sedan = new Sedan(YEAR, Model.AUDI_A4, EngineVolume.HIGH, Color.RED, WheelSize.SMALL, 4, new HashSet<>());
        this.storage.addCarToStorage(sedan);
        Set<Option> options = new HashSet<>();
        options.add(Option.ABS);
        sedan = new Sedan(YEAR, Model.BMW_x6, EngineVolume.LOW, Color.RED, WheelSize.SMALL, 4, options);
        this.storage.addCarToStorage(sedan);
    }
}
