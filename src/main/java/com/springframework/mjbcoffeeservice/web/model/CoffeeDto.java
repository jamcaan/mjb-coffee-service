package com.springframework.mjbcoffeeservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/*
    Created by Mohamed Jama 7/20/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeDto {
    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String coffeeName;
    private CoffeeStyleEnum coffeeStyle;

    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;

}
