package com.sofia.uni.fmi.travelly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Trips",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "trip_id") }
    )
    private List<Trip> trips;

    public void addTrip(Trip trip) {
        trips.add(trip);
    }
}
