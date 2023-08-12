package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
