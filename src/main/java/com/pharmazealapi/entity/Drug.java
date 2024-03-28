package com.pharmazealapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="drug")
public class Drug {
    @Id
    @Column(name = "drug_id")
    private String drugId;
    @Column(name = "drug_name")
    private String name;
    @Column(name = "health_condition")
    private String healthCondition;
    @Column(name = "id_check")
    private String idCheck;
    @Column(name = "price")
    private int price;
}
