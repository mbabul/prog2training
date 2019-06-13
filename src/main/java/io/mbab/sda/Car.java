package io.mbab.sda;

import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private String model;

    public void setModel(String model) {
        this.model = model;
    }


    // różnica pomiędzy metodami peek(), a map() w Stream

    public List<Car> setModelToCarsByPeek(List<Car> cars) {
        return cars
                .stream()
                .peek(e -> e.setModel("3"))
                .collect(Collectors.toList());


    }

    public List<Car> setModelToCarsByMap(List<Car> cars) {
        return cars
                .stream()
                .map(e -> {
                    e.setModel("3");
                    return e;
                })
                .collect(Collectors.toList());


    }

}
