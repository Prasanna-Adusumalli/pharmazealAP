package com.pharmazealapi.repository;

import com.pharmazealapi.entity.Location;
import com.pharmazealapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {
    Optional<Location> findByLocationNameEqualsIgnoreCase(String locationName);
}
