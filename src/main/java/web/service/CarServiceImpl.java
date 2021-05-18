package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.model.Car;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarDAO carDao;

    public CarServiceImpl(@Autowired CarDAO carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(int amount) {
        return carDao.getCarList().subList(0, amount);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getCarList();
    }
}
