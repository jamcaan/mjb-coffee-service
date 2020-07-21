package com.springframework.mjbcoffeeservice.repositories;

import com.springframework.mjbcoffeeservice.domain.Coffee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CoffeeRepository extends PagingAndSortingRepository<Coffee, UUID> {
}
