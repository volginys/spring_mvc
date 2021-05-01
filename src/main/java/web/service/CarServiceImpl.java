package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAOImpl;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDAOImpl carDao;

    @Override
    public List<Car> getCars(int amount) {
        return carDao.getCarList().subList(0,amount);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getCarList();
    }

    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public Car findByModel(String carModel) {
        return carDao.findByModel(carModel);
    }

    @Override
    public void updateByModel(String carModel, Car car) {
        carDao.updateByModel(carModel, car);
    }
}
