package com.springframework.mjbcoffeeservice.web.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeController.class)
class CoffeeControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;



    @Test
    void getCoffeeById() throws Exception {
        mockMvc.perform(get("/api/v1/coffee/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveCoffee() throws Exception {
        CoffeeDto coffeeDto = CoffeeDto.builder().build();
        String coffeeDtoJson = objectMapper.writeValueAsString(coffeeDto);

        mockMvc.perform(post("/api/v1/coffee/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(coffeeDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateCoffeeById() throws Exception {
        CoffeeDto coffeeDto = CoffeeDto.builder().build();
        String coffeeDtoJson = objectMapper.writeValueAsString(coffeeDto);

        mockMvc.perform(put("/api/v1/coffee/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(coffeeDtoJson))
                .andExpect(status().isNoContent());





    }
}