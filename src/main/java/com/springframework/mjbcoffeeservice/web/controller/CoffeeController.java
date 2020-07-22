package com.springframework.mjbcoffeeservice.web.controller;

import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Mohamed Jama 7/20/20
 */
@RequestMapping("/api/v1/coffee")
@RestController
public class CoffeeController {

    @GetMapping("/{coffeeId}")
    public ResponseEntity<CoffeeDto> getCoffeeById(@PathVariable ("coffeeId") UUID coffeeId){
        //todo impl
        return new ResponseEntity<>(CoffeeDto.builder().build(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity saveCoffee(@RequestBody @Validated CoffeeDto coffeeDto){
        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{coffeeId}")
    public ResponseEntity updateCoffeeById (@PathVariable("coffeeId") UUID coffeeId, @RequestBody @Validated CoffeeDto coffeeDto){
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }





}
