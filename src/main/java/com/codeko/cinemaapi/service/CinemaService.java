package com.codeko.cinemaapi.service;

import com.codeko.cinemaapi.repository.CinemaRepository;
import com.codeko.cinemaapi.repository.entity.Cinema;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    private CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema save(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}
