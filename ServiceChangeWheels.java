package homework_4.cars.service;

import com.roman.lis.hw.homework3.cars.model.Car;
import com.roman.lis.hw.homework3.cars.model.enums.*;

public class ServiceChangeWheels {
    public void changeWheels(Car car, WheelSize wheelSize) {
        if (car != null && wheelSize != null && !wheelSize.equals(car.getWheelSize())) {
            car.setWheelSize(wheelSize.ordinal());
        }
    }
}
