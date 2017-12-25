package com.codeko.cinemaapi.repository.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "showtime")
@Data
@Builder
public class Showtime {

    @Id
    @Column(updatable = false, insertable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String sessionId;

    @Column
    private LocalDateTime datetime;

    @Column
    private int screenNum;

    @Column
    private int seatsAvailable;

    @Column
    private String screenName;

    @Column
    private String attributes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_system_id")
    private ShowtimeSystem showtimeSystem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduler_job_id", nullable = false)
    private SchedulerJob schedulerJob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Cinema cinema;

}
