package com.pharmazealapi.repository;

import com.pharmazealapi.entity.ExistingPrescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExistingPrescriptionRepository extends JpaRepository<ExistingPrescription,Integer> {
}
