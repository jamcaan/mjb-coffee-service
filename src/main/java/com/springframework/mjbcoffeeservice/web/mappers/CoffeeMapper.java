package com.springframework.mjbcoffeeservice.web.mappers;

import com.springframework.mjbcoffeeservice.domain.Coffee;
import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CoffeeMapper {

    CoffeeDto CoffeeToCoffeeDto (Coffee coffee);
    Coffee CoffeeDtoToCoffee(CoffeeDto dto);
}
