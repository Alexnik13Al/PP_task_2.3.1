package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> carList;
    public CarService() {
        carList = new ArrayList<>();
        carList.add(new Car("Lamborghini",2024,"orange"));
        carList.add(new Car("Maserati",2022,"blue"));
        carList.add(new Car("BMW",2021,"black"));
        carList.add(new Car("Mersedes-Benz",2020,"green"));
        carList.add(new Car("Haval",2023,"white"));
    }

    public List<Car> getCar(int numberOfCars) {
        return carList.subList(0,numberOfCars);
    }
}
