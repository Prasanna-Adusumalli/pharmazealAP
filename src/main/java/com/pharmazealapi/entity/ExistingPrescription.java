package com.pharmazealapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="existing_prescription")
public class ExistingPrescription {
    @Id
    @Column(name="prescription_id")
    private int id;
    @Column(name="customer_nhs_number")
    private int customerNHS;
    @Column(name="drug_id")
    private String drugId;
    @Column(name="quantity")
    private int quantity;
    @Column(name="location_id")
    private int locationId;
    @Column(name="status")
    private String status;
}
