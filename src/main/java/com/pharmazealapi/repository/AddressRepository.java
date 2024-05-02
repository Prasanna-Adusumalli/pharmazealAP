package com.pharmazealapi.repository;

import com.pharmazealapi.entity.Address;
import com.pharmazealapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
