package com.sofia.uni.fmi.travelly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="itinerary_id")
    private Itinerary itinerary;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private Double pricePerNight;
}
