package com.codeko.cinemaapi.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie_cinema")
@AssociationOverrides({
        @AssociationOverride(name = "pk.movie", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id")),
        @AssociationOverride(name = "pk.cinema", joinColumns = @JoinColumn(name = "cinema_id", referencedColumnName = "id"))
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MovieCinema {

    @EmbeddedId
    private MovieCinemaId pk = new MovieCinemaId();

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date", nullable = false, length = 10)
    private Date createdDate;

    @Column(name = "created_by", nullable = false, length = 20)
    private String createdBy;

    @Transient
    public Movie getMovie() {
        return getPk().getMovie();
    }

    public void setMovie(Movie movie) {
        getPk().setMovie(movie);
    }

    @Transient
    public Cinema getCinema() {
        return getPk().getCinema();
    }

    public void setCinema(Cinema cinema) {
        getPk().setCinema(cinema);
    }

}
