package com.codeko.cinemaapi.repository.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "movie")
@Data
@Builder
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
}
