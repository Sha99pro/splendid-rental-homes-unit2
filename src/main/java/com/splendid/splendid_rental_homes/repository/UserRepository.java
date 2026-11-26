package com.splendid.splendid_rental_homes.repository;

import com.splendid.splendid_rental_homes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
}
