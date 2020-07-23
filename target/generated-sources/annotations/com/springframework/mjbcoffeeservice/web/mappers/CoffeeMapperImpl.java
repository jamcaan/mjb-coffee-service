package com.springframework.mjbcoffeeservice.web.mappers;

import com.springframework.mjbcoffeeservice.domain.Coffee;
import com.springframework.mjbcoffeeservice.domain.Coffee.CoffeeBuilder;
import com.springframework.mjbcoffeeservice.web.model.CoffeeDto;
import com.springframework.mjbcoffeeservice.web.model.CoffeeDto.CoffeeDtoBuilder;
import com.springframework.mjbcoffeeservice.web.model.CoffeeStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-22T19:22:33-0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CoffeeMapperImpl implements CoffeeMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public CoffeeDto CoffeeToCoffeeDto(Coffee coffee) {
        if ( coffee == null ) {
            return null;
        }

        CoffeeDtoBuilder coffeeDto = CoffeeDto.builder();

        coffeeDto.id( coffee.getId() );
        if ( coffee.getVersion() != null ) {
            coffeeDto.version( coffee.getVersion().intValue() );
        }
        coffeeDto.createdDate( dateMapper.asOffsetDateTime( coffee.getCreatedDate() ) );
        coffeeDto.lastModifiedDate( dateMapper.asOffsetDateTime( coffee.getLastModifiedDate() ) );
        coffeeDto.coffeeName( coffee.getCoffeeName() );

        if ( coffee.getCoffeeStyle() != null ) {
            coffeeDto.coffeeStyle( Enum.valueOf( CoffeeStyleEnum.class, coffee.getCoffeeStyle() ) );
        }
        coffeeDto.upc( coffee.getUpc() );
        coffeeDto.price( coffee.getPrice() );

        return coffeeDto.build();
    }

    @Override
    public Coffee CoffeeDtoToCoffee(CoffeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        CoffeeBuilder coffee = Coffee.builder();

        coffee.id( dto.getId() );
        if ( dto.getVersion() != null ) {
            coffee.version( dto.getVersion().longValue() );
        }
        coffee.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        coffee.lastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        coffee.coffeeName( dto.getCoffeeName() );
        if ( dto.getCoffeeStyle() != null ) {
            coffee.coffeeStyle( dto.getCoffeeStyle().name() );
        }
        coffee.upc( dto.getUpc() );
        coffee.price( dto.getPrice() );

        return coffee.build();
    }
}
