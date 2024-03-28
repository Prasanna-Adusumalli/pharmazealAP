package com.pharmazealapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="drug_availability")
public class DrugAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_id")
    private int availabilityId;
    @Column(name = "drug_id")
    private String drugId;
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "availability")
    private String availability;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "expiry_date")
    private Date expiryDate;

}
