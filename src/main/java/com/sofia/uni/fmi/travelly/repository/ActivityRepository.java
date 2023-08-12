package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Activity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
