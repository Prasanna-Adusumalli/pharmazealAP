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
@Table(name="sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sales_id")
    private int salesId;
    @Column(name="location_id")
    private int locationId;
    @Column(name="customer_nhs")
    private int customerNHS;
    @Column(name="customer_name")
    private String customerName;
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="id_verified")
    private String idVerified;
    @Column(name="sales_date")
    private Date salesDate;

}
