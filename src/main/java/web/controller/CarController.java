package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.html.HTML.Attribute.N;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(required = false) Integer count, ModelMap modelCar) {
        List<Car> messagesCar;
        if (count == null || count >= 5) {
            messagesCar = carService.getCar(5);
        } else {
            messagesCar = carService.getCar(count);
        }
        modelCar.addAttribute("messagesCar", messagesCar);
        return "car";
    }
}
