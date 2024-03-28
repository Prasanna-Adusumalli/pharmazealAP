package com.pharmazealapi.repository;

import com.pharmazealapi.entity.Drug;
import com.pharmazealapi.entity.DrugAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugAvailabilityRepository extends JpaRepository<DrugAvailability,Integer> {
    Optional<DrugAvailability> findByDrugIdAndLocationId(String drugId, int locationId);
    public List<DrugAvailability> findAllByLocationId(int locationId);
}
