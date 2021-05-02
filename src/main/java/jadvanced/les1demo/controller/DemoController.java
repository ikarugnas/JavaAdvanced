package jadvanced.les1demo.controller;

import jadvanced.les1demo.model.Car;
import jadvanced.les1demo.service.CarService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class DemoController {

    //@Autowired en Constructor doen hetzelfde.
    @Autowired
    CarService carService;


    public DemoController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping()
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }


    @PutMapping()
    public ResponseEntity updateCar(@RequestBody Car car) {
        carService.updateCar(car);
        return ResponseEntity.status(200).body("The car at id " + car.getId() + " has been updated with " + car);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity deleteCar(@PathVariable long carId) {
        carService.removeCar(carId);
        return ResponseEntity.status(200).body("Car with id of " + carId + " has successfully been removed.");
    }


//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String test() {
//        return "Hello";
//    }

//    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity getAllCarss() {
//        List<Car> cars = carService.getAllCars();
//        return ResponseEntity.status(200).body(cars);
//    }
}



