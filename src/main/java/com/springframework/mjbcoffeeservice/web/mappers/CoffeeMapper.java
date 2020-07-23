package com.springframework.mjbcoffeeservice.web.mappers;

import com.springframework.mjbcoffeeservice.domain.Coffee;
import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CoffeeMapper {

    CoffeeDto coffeeToCoffeeDto (Coffee coffee);
    Coffee coffeeDtoToCoffee(CoffeeDto dto);
}
