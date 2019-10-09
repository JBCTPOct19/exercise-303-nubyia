package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    CarRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Cars cars;
        cars = new Cars("2009","Nissan", "Altima");
        repository.save(cars);

            cars = new Cars("2004","Ford", "Flex");
            repository.save(cars);

            Cars car;
            cars = new Cars("1997","Ford", "Taurus");
            repository.save(cars);

    }

}
