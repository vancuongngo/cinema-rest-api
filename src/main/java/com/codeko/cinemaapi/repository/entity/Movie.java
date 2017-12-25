package com.codeko.cinemaapi.repository.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"movie_id", "id"})
})
@Data
@Builder
@EqualsAndHashCode(exclude = "movieCinemas")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String movieName;

    @Column(name = "movie_id")
    private String movieId;

    @Column
    private LocalDateTime releaseDateTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private Set<Showtime> showtimes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduler_job_id", nullable = false)
    private SchedulerJob schedulerJob;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.cinema", cascade = CascadeType.ALL)
    private Set<MovieCinema> movieCinemas = new HashSet<>();

}
