package com.pharmazealapi.repository;

import com.pharmazealapi.entity.ExistingPrescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExistingPrescriptionRepository extends JpaRepository<ExistingPrescription,Integer> {
    List<ExistingPrescription> findAllByLocationId(int locationId);
}
