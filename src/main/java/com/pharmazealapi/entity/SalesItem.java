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
@Table(name="sales_item")
public class SalesItem {
    @Id
    @Column(name="sale_item_id")
    private int saleItemId;
    @Column(name="sales_id")
    private int salesId;
    @Column(name="drug_id")
    private String drugId;
    private int quantity;
    private Double price;
}
