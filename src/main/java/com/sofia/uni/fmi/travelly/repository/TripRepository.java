package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
