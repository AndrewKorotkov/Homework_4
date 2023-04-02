package homework_4.cars.service;

import com.roman.lis.hw.homework3.cars.model.Car;
import com.roman.lis.hw.homework3.cars.model.enums.*;

import java.util.Set;

public class ServiceOptions {

    public void addOption(Car car, Option option) {
        if (car != null && option != null) {
            car.getOptions().add(option);
        }
    }

    public void deleteOption(Car car, Option option) {
        if (car != null && option != null) {
            car.getOptions().remove(option);
        }
    }

    public void setOptions(Car car, Set<Option> options) {
        if (car != null && options != null) {
            car.setOptions(options);
        }
    }
}
