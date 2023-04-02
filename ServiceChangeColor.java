package homework_4.cars.service;

import com.roman.lis.hw.homework3.cars.model.Car;
import com.roman.lis.hw.homework3.cars.model.enums.*;

public class ServiceChangeColor {
    public void changeColor(Car car, Color color) {
        if (car != null && color != null && !color.equals(car.getColor())) {
            car.setColor(color);
        }
    }
}
