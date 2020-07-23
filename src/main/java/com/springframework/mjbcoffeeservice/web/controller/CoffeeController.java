package com.springframework.mjbcoffeeservice.web.controller;

import com.springframework.mjbcoffeeservice.services.CoffeeService;
import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Mohamed Jama 7/20/20
 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/coffee")
@RestController
public class CoffeeController {

    private CoffeeService coffeeService;

    @GetMapping("/{coffeeId}")
    public ResponseEntity<CoffeeDto> getCoffeeById(@PathVariable ("coffeeId") UUID coffeeId){

        return new ResponseEntity<>(coffeeService.getCoffeeById(coffeeId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity saveCoffee(@RequestBody @Validated CoffeeDto coffeeDto){

        return new ResponseEntity<>(coffeeService.saveCoffee(coffeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/{coffeeId}")
    public ResponseEntity updateCoffeeById (@PathVariable("coffeeId") UUID coffeeId, @RequestBody @Validated CoffeeDto coffeeDto){

        return new ResponseEntity<>(coffeeService.updateCoffeeById(coffeeId, coffeeDto), HttpStatus.NO_CONTENT);
    }





}
