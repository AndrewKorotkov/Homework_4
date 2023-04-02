package homework_4.cars.factory;

import com.roman.lis.hw.homework3.cars.model.Car;
import com.roman.lis.hw.homework3.cars.model.enums.*;
import homework_4.cars.model.SUV;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
public class SUVFactory {
    private static final int YEAR = 2023;

    private final Color[] colors;
    private final Model[] models;
    private final WheelSize[] wheelSizes;
    private final EngineVolume[] engineVolumes;
    private final byte numSeats;

    private final Storage storage;

    public SUVFactory(Color[] colors, Model[] models, WheelSize[] wheelSizes, EngineVolume[] engineVolumes, byte numSeats) {
        this.colors = colors;
        this.models = models;
        this.wheelSizes = wheelSizes;
        this.engineVolumes = engineVolumes;
        this.numSeats = numSeats;
        this.storage = new Storage();
        fillStorageWithCars();
    }

    public SUV createSUV(Model model, EngineVolume engineVolume, Color color, WheelSize wheelSize, byte numSeats, Set<Option> options) {
        SUV suv = storage.getCarFromStorage(model, engineVolume, color, wheelSize, numSeats);
        if (suv != null) {
            if (suv.getColor() != color) {
                suv.setColor(color);
            }
            if (suv.getWheelSize() != wheelSize) {
                suv.setWheelSize(wheelSize);
            }
            // Add options check if needed.
            suv.setOptions(options);
            return suv;
        }
        return new SUV(YEAR, model, engineVolume, color, wheelSize, numSeats, options);
    }

    public String getConfigurations() {
        return format(
                "Factory can produce: colors: %s, models: %s, wheelSizes: %s, engineVolumes: %s, numSeats: %s",
                Arrays.toString(colors),
                Arrays.toString(models),
                Arrays.toString(wheelSizes),
                Arrays.toString(engineVolumes),
                Arrays.toString(new byte[]{numSeats})
        );
    }


    private void fillStorageWithCars() {
        // Any custom logic about creating initial cars.
        Car suv = new SUV(YEAR, Model.AUDI_A4, EngineVolume.HIGH, Color.RED, WheelSize.SMALL, 4, new HashSet<>());
        this.storage.addCarToStorage(suv);
        Set<Option> options = new HashSet<>();
        options.add(Option.ABS);
        suv = new SUV(YEAR, Model.BMW_x6, EngineVolume.LOW, Color.RED, WheelSize.SMALL, 4, options);
        this.storage.addCarToStorage(suv);
    }
}
