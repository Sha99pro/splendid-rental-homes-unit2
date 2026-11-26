package com.splendid.splendid_rental_homes.repository;

import com.splendid.splendid_rental_homes.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
