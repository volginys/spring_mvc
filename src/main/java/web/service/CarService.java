package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getCars(int amount);

    List<Car> getAllCars();

    void add(Car car);

    Car findByModel(String carModel);

    void updateByModel(String carModel, Car car);
}

