package com.codeko.cinemaapi.repository.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "scheduler_job")
@Builder
public class SchedulerJob {

    @Id
    @Column(updatable = false, insertable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime updated;

    @Column
    private LocalDateTime created;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedulerJob")
    private Set<Cinema> cinemas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedulerJob")
    private Set<Movie> movies;
}
