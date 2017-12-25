package com.codeko.cinemaapi.repository.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "showtime_system")
@Builder
public class ShowtimeSystem {

    @Id
    @Column(updatable = false, insertable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    private String url;

    @OneToMany(mappedBy = "showtimeSystem", cascade = CascadeType.ALL)
    private Set<Showtime> showtimes;
}
