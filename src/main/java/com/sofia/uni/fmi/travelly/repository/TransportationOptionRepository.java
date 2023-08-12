package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.TransportationOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportationOptionRepository extends JpaRepository<TransportationOption, Long> {
}
