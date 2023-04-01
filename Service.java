package homework_4.cars.service;

import com.roman.lis.hw.homework3.cars.model.Car;
import com.roman.lis.hw.homework3.cars.model.enums.*;

import java.util.Set;

public class Service {

    public void changeColor(Car car, Color color) {
        if (car != null && color != null && !color.equals(car.getColor())) {
            car.setColor(color);
        }
    }

    public void changeWheels(Car car, WheelSize wheelSize) {
        if (car != null && wheelSize != null && !wheelSize.equals(car.getWheelSize())) {
            car.setWheelSize(wheelSize);
        }
    }

    public void addOption(Car car, Option option) {
        if (car != null && option != null) {
            car.getOptions().add(option);
        }
    }

    public void removeOption(Car car, Option option) {
        if (car != null && option != null) {
            car.getOptions().remove(option);
        }
    }

    public void setOptions(Car car, Set<Option> options) {
        if (car != null && options != null) {
            car.setOptions(options);
        }
    }

    public static class PaintService {
        public void paintCar(Car car, String newColor) {
            car.setColor(Color.valueOf(newColor));
        }
    }

    public static class WheelService {
        public void changeWheelSize(Car car, int newWheelSize) {
            car.setWheelSize(newWheelSize);
        }
    }

    public static class OptionService {
        public void addOption(Car car, String newOption) {
            Set<Option> options = car.getOptions();
            options.add(Option.valueOf(newOption));
            car.setOptions(options);
        }

        public void removeOption(Car car, String optionToRemove) {
            Set<Option> options = car.getOptions();
            options.remove(optionToRemove);
            car.setOptions(options);
        }
    }

}
