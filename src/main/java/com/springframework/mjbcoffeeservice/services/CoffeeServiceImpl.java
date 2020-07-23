package com.springframework.mjbcoffeeservice.services;

import com.springframework.mjbcoffeeservice.domain.Coffee;
import com.springframework.mjbcoffeeservice.repositories.CoffeeRepository;
import com.springframework.mjbcoffeeservice.web.controller.NotFoundException;
import com.springframework.mjbcoffeeservice.web.mappers.CoffeeMapper;
import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CoffeeServiceImpl implements CoffeeService{

   private final CoffeeRepository coffeeRepository;
   private final CoffeeMapper coffeeMapper;


    @Override
    public CoffeeDto getCoffeeById(UUID coffeeId) {
        return coffeeMapper.coffeeToCoffeeDto(
                coffeeRepository.findById(coffeeId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public CoffeeDto saveCoffee(CoffeeDto coffeeDto) {
        return coffeeMapper.coffeeToCoffeeDto(coffeeRepository.save(coffeeMapper.coffeeDtoToCoffee(coffeeDto)));
    }

    @Override
    public CoffeeDto updateCoffeeById(UUID coffeeId, CoffeeDto coffeeDto) {

        Coffee coffee = coffeeRepository.findById(coffeeId).orElseThrow(NotFoundException::new);
        coffee.setCoffeeName(coffeeDto.getCoffeeName());
        coffee.setCoffeeStyle(coffeeDto.getCoffeeStyle().name());
        coffee.setPrice(coffeeDto.getPrice());
        coffee.setUpc(coffeeDto.getUpc());

        return coffeeMapper.coffeeToCoffeeDto(coffeeRepository.save(coffee));
    }
}
