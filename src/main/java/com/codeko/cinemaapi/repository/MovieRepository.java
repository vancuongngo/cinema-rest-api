package com.codeko.cinemaapi.repository;

import com.codeko.cinemaapi.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
