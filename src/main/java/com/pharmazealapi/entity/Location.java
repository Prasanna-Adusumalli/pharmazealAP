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
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;
    @Column(name = "location_name")
    private String locationName;
    @Column(name = "location_code")
    private String locationCode;

    @Override
    public String toString() {
        return String.format
                ("%s, %s", locationName, locationCode);
    }

}
