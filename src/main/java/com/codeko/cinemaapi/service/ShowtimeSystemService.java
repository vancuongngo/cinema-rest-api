package com.codeko.cinemaapi.service;

import com.codeko.cinemaapi.repository.ShowtimeSystemRepository;
import com.codeko.cinemaapi.repository.entity.ShowtimeSystem;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeSystemService {

    private ShowtimeSystemRepository showtimeSystemRepository;

    public ShowtimeSystemService(ShowtimeSystemRepository showtimeSystemRepository) {
        this.showtimeSystemRepository = showtimeSystemRepository;
    }

    public ShowtimeSystem save(ShowtimeSystem showtimeSystem) {
        return showtimeSystemRepository.save(showtimeSystem);
    }
}
