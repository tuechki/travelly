package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository extends JpaRepository<Item, Long> {
}
