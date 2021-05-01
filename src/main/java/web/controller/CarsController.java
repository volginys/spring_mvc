package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public String index(@RequestParam(value = "count", required = false) String count, Model model) {
        Integer amount=0;
        try {
            amount = Integer.parseInt(count);
        }catch (Exception e){
            System.out.println("Error");
        }
        List<Car> carList = carService.getAllCars();
        if ((amount>0)&(amount<5)) {
            carList = carService.getCars(amount);
        }
        model.addAttribute("cars", carList);
        return "/cars/index";
    }


    @GetMapping("/new")
    public String newCar(Model model){
        model.addAttribute("car", new Car());
        return "/cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") Car car){
        carService.add(car);
        return "redirect:/cars";
    }
    @GetMapping("/{model}")
    public String show(Model model, @PathVariable("model") String carModel){
        Car car = carService.findByModel(carModel);
        model.addAttribute("cars", Arrays.asList(car));
        return "/cars/index";
    }

    @GetMapping("/{model}/edit")
    public String edit(Model model, @PathVariable("model") String carModel){
        System.out.println(carModel);
        Car car = carService.findByModel(carModel);
        model.addAttribute("car", car);
        return "/cars/edit";
    }

    @PatchMapping("/{model}")
    public String update(@ModelAttribute("car") Car car, @PathVariable("model") String carModel){
        carService.updateByModel(carModel, car);
        return "redirect:/cars";
    }
}

