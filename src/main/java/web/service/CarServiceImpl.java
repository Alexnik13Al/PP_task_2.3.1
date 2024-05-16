package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList;

    public CarServiceImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("Lamborghini", 2024, "orange"));
        carList.add(new Car("Maserati", 2022, "blue"));
        carList.add(new Car("BMW", 2021, "black"));
        carList.add(new Car("Mersedes-Benz", 2020, "green"));
        carList.add(new Car("Haval", 2023, "white"));
    }

    @Override
    public List<Car> getCar(int numberOfCars) {
        return carList.subList(0, numberOfCars);
    }

    public List<Car> processCarData(Integer count) {
        List<Car> messagesCar;
        if (count == null || count >= 5) {
            messagesCar = getCar(5);
        } else {
            messagesCar = getCar(count);
        }
        return messagesCar;
    }
}
