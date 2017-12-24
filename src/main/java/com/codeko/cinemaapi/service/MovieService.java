package com.codeko.cinemaapi.service;

import com.codeko.cinemaapi.repository.MovieRepository;
import com.codeko.cinemaapi.repository.entity.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
