package com.codeko.cinemaapi.repository;

import com.codeko.cinemaapi.repository.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
