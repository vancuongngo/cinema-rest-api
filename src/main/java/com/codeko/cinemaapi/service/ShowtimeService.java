package com.codeko.cinemaapi.service;

import com.codeko.cinemaapi.repository.ShowtimeRepository;
import com.codeko.cinemaapi.repository.entity.Showtime;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {

    private ShowtimeRepository showtimeRepository;

    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    public Showtime save(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }
}
