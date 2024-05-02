package com.pharmazealapi.repository;

import com.pharmazealapi.entity.Sales;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
    List<Sales> findAllByLocationId(int locationId);
}
