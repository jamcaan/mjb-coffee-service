package com.springframework.mjbcoffeeservice.services;

import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;

import java.util.UUID;

public interface CoffeeService {
    CoffeeDto getCoffeeById(UUID coffeeId);

    CoffeeDto saveCoffee(CoffeeDto coffeeDto);

    CoffeeDto updateCoffeeById(UUID coffeeId, CoffeeDto coffeeDto);
}
