package com.codeko.cinemaapi.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieCinemaId implements Serializable {

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Cinema cinema;

}
