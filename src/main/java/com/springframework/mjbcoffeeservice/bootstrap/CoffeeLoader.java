package com.springframework.mjbcoffeeservice.bootstrap;

import com.springframework.mjbcoffeeservice.domain.Coffee;
import com.springframework.mjbcoffeeservice.repositories.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CoffeeLoader implements CommandLineRunner {

    private final CoffeeRepository coffeeRepository;

    public CoffeeLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loaderObjects();

    }

    private void loaderObjects() {
        if (coffeeRepository.count() == 0){

            coffeeRepository.save(Coffee.builder()
                    .coffeeName("Arabica")
                    .coffeeStyle("BLACK")
                    .quantityToBrew(400)
                    .minOnHand(50)
                    .upc(345687363452L)
                    .price(new BigDecimal("14.99"))
                    .build());

            coffeeRepository.save(Coffee.builder()
                    .coffeeName("Robusta")
                    .coffeeStyle("CAPPUCCINO")
                    .quantityToBrew(400)
                    .minOnHand(50)
                    .upc(256387363451L)
                    .price(new BigDecimal("13.99"))
                    .build());
        }


    }

}
