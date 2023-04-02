package homework_4.cars.factory;

import com.roman.lis.hw.homework3.cars.model.Car;
import com.roman.lis.hw.homework3.cars.model.enums.*;
import homework_4.cars.model.SportsCar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
public class SportsCarFactory {
    private static final int YEAR = 2023;

    private final Color[] colors;
    private final Model[] models;
    private final WheelSize[] wheelSizes;
    private final EngineVolume[] engineVolumes;
    private final String bodyType;

    private final Storage storage;

    public SportsCarFactory(Color[] colors, Model[] models, WheelSize[] wheelSizes, EngineVolume[] engineVolumes, String bodyType) {
        this.colors = colors;
        this.models = models;
        this.wheelSizes = wheelSizes;
        this.engineVolumes = engineVolumes;
        this.bodyType = bodyType;
        this.storage = new Storage();
        fillStorageWithCars();
    }

    public SportsCar createSportsCar(Model model, EngineVolume engineVolume, Color color, WheelSize wheelSize, String bodyType, Set<Option> options) {
        SportsCar sportscar = storage.getCarFromStorage(model, engineVolume, color, wheelSize);
        if (sportscar != null) {
            if (sportscar.getColor() != color) {
                sportscar.setColor(color);
            }
            if (sportscar.getWheelSize() != wheelSize) {
                sportscar.setWheelSize(wheelSize);
            }

            sportscar.setOptions(options);
            return sportscar;
        }
        return new SportsCar(YEAR, model, engineVolume, color, wheelSize, bodyType, options);
    }

    public String getConfigurations() {
        return format(
                "Factory can produce: colors: %s, models: %s, wheelSizes: %s, engineVolumes: %s, bodyType: %s",
                Arrays.toString(colors),
                Arrays.toString(models),
                Arrays.toString(wheelSizes),
                Arrays.toString(engineVolumes)
        );
    }


    private void fillStorageWithCars() {
        Car sportscar = new SportsCar(YEAR, Model.AUDI_A4, EngineVolume.HIGH, Color.RED, WheelSize.SMALL, "cabriolet", new HashSet<>());
        this.storage.addCarToStorage(sportscar);
        Set<Option> options = new HashSet<>();
        options.add(Option.ABS);
        sportscar = new SportsCar(YEAR, Model.BMW_x6, EngineVolume.LOW, Color.RED, WheelSize.SMALL, "estate car", options);
        this.storage.addCarToStorage(sportscar);
    }
}
