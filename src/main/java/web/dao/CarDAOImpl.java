package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImpl {

    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("BMW","M3","black"));
        carList.add(new Car("Mersedes","AMG","black"));
        carList.add(new Car("Lada","Vesta","boclagan"));
        carList.add(new Car("Nissan","GTR","white"));
        carList.add(new Car("Ferrari","458","red"));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void add(Car car){
        carList.add(car);
    }

    public Car findByModel(String carModel) {
        return carList.stream().filter(p -> p.getModel().equals(carModel)).findFirst().get();
    }

    public void updateByModel(String carModel, Car car) {
        Car carToUpdate = findByModel(carModel);
        carToUpdate.setModel(car.getModel());
        carToUpdate.setSeries(car.getSeries());
        carToUpdate.setColor(car.getColor());
    }
}
