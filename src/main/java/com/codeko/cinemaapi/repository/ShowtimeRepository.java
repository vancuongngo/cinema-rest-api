package com.codeko.cinemaapi.repository;

import com.codeko.cinemaapi.repository.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}
