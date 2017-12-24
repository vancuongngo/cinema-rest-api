package com.codeko.cinemaapi.repository;

import com.codeko.cinemaapi.repository.entity.ShowtimeSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeSystemRepository extends JpaRepository<ShowtimeSystem, Long> {
}
