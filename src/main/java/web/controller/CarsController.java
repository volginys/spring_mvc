package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.List;

@Controller
@RequestMapping(value = "/cars")
public class CarsController {

    private CarService carService;

    public CarsController(@Autowired CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String countCars(@RequestParam(value = "count", required = false) String count,
                            Model model) {
        Integer amount = -1;
        List<Car> carList = carService.getAllCars();
        try {
            if(count!=null){
                amount = Integer.parseInt(count);
                if(amount < 0){
                    throw new ArrayIndexOutOfBoundsException();
                }
            }
        } catch (Throwable e) {
            return "/error";
        }
        if ((amount >= 0) & (amount < 5)) {
            carList = carService.getCars(amount);
        }
        model.addAttribute("cars", carList);
        return "/cars";
    }
}
