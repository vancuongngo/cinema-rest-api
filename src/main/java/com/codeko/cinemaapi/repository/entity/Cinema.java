package com.codeko.cinemaapi.repository.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cinema")
@Data
@Builder
@EqualsAndHashCode(exclude = "movieCinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String cinemaName;

    @Column
    private String cinemaId;

    @Column
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cinema")
    private Set<Showtime> showtimes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduler_job_id", nullable = false)
    private SchedulerJob schedulerJob;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.movie", cascade = CascadeType.ALL)
    private Set<MovieCinema> movieCinemas = new HashSet<>(0);

}
