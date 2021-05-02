package jadvanced.les1demo.service;

import jadvanced.les1demo.repository.CarRepository;
import org.springframework.stereotype.Service;

import jadvanced.les1demo.model.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;

    private List<Car> cars = new ArrayList<Car>();

    public CarService() {
        cars.add(new Car(1, "Ferrari", "F40", 200000, 1988));
        cars.add(new Car(2, "Porsche", "Panamera", 100000, 2018));
    }

    public List<Car> getAllCars() {
        return cars;
        //return carRepository.findAll();
    }

    public Car addCar(Car car) {
        cars.add(car);
        return car;
    }

    public void removeCar(long carId) {
        int index = 0;
        for(Car c : cars) {

            if (c.getId() == carId) {
                cars.remove(index);
            }
            index++;
        }

    }

    public void updateCar(Car updatedCar) {
        int index = 0;
        for(Car c : cars) {

            if (c.getId() == updatedCar.getId()) {
                cars.set(index, updatedCar);
            }
            index++;
        }

//        cars.set(updatedCar.getId(), updatedCar);
//        long carId = updatedCar.getId();
//        Car carToUpdate = cars.get((int)carId);
//        Collections.replaceAll(cars, carToUpdate, updatedCar);
    }
}
