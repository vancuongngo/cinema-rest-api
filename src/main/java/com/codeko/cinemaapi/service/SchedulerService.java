package com.codeko.cinemaapi.service;

import com.codeko.cinemaapi.annotation.LogExecutionTime;
import com.codeko.cinemaapi.repository.SchedulerRepository;
import com.codeko.cinemaapi.repository.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;

@Service
public class SchedulerService {

    private MovieService movieService;

    private CinemaService cinemaService;

    private ShowtimeService showtimeService;

    private ShowtimeSystemService showtimeSystemService;

    private SchedulerRepository schedulerRepository;

    public SchedulerService(MovieService movieService, CinemaService cinemaService,
                            ShowtimeService showtimeService, ShowtimeSystemService showtimeSystemService,
                            SchedulerRepository schedulerRepository) {
        this.movieService = movieService;
        this.cinemaService = cinemaService;
        this.showtimeService = showtimeService;
        this.showtimeSystemService = showtimeSystemService;
        this.schedulerRepository = schedulerRepository;
    }

    @LogExecutionTime(id = "Trigger Scheduler Job", pretty = true)
    public String triggerSchedulerJob() {
        SchedulerJob schedulerJob = this.save(new SchedulerJob());

        Cinema cinema = cinemaService.save(Cinema.builder()
                .cinemaId("cinemaId-1")
                .cinemaName("CGV")
                .schedulerJob(schedulerJob)
                .address("Danang-VN")
                .build());

        Movie thorRagnarok = movieService.save(Movie.builder()
                .movieId("movieId-1")
                .movieName("Thor Ragnorok")
                .releaseDateTime(LocalDateTime.now().minusDays(1))
                .schedulerJob(schedulerJob)
                .build());

        Movie jigSaw = movieService.save(Movie.builder()
                .movieId("movieId-2")
                .movieName("JigSaw")
                .releaseDateTime(LocalDateTime.now().minusDays(5))
                .schedulerJob(schedulerJob)
                .build());

        ShowtimeSystem digital = showtimeSystemService.save(ShowtimeSystem.builder()
                .name("Digital")
                .url("url to digital logo")
                .build());

        ShowtimeSystem md4x = showtimeSystemService.save(ShowtimeSystem.builder()
                .name("MD4X")
                .url("url to MD4X logo")
                .build());

        Showtime showtime1 = showtimeService.save(Showtime.builder()
                .cinema(cinema)
                .movie(thorRagnarok)
                .schedulerJob(schedulerJob)
                .screenNum(1)
                .seatsAvailable(100)
                .attributes("EN")
                .datetime(LocalDateTime.now().minusHours(5))
                .screenName("screen-name-1")
                .sessionId("session-id-1")
                .showtimeSystem(digital)
                .build());

        Showtime showtime2 = showtimeService.save(Showtime.builder()
                .cinema(cinema)
                .movie(thorRagnarok)
                .schedulerJob(schedulerJob)
                .screenNum(2)
                .seatsAvailable(90)
                .attributes("EN")
                .datetime(LocalDateTime.now().minusHours(10))
                .screenName("screen-name-2")
                .sessionId("session-id-1")
                .showtimeSystem(digital)
                .build());

        return "Success";
    }

    private SchedulerJob save(SchedulerJob schedulerJob) {
        return this.schedulerRepository.save(schedulerJob);
    }

    public String triggerManyToManySavingProcess() {

        SchedulerJob schedulerJob = new SchedulerJob();

        this.save(schedulerJob);

        Movie thorRagnorok = Movie.builder()
                .movieName("Thor Ragnorok")
                .schedulerJob(schedulerJob)
                .movieCinemas(new HashSet<>())
                .build();

        Movie jigSaw = Movie.builder()
                .movieName("Jig Saw")
                .schedulerJob(schedulerJob)
                .movieCinemas(new HashSet<>())
                .build();

        Cinema cvg = Cinema.builder()
                .cinemaName("CGV")
                .schedulerJob(schedulerJob)
                .build();

        Cinema vincom = Cinema.builder()
                .cinemaName("Vincom")
                .schedulerJob(schedulerJob)
                .build();

        cinemaService.save(cvg);
        cinemaService.save(vincom);

        MovieCinema movieCinema_thorRagnorok = new MovieCinema();
        movieCinema_thorRagnorok.setMovie(thorRagnorok);
        movieCinema_thorRagnorok.setCinema(cvg);
        movieCinema_thorRagnorok.setCreatedDate(new Date());
        movieCinema_thorRagnorok.setCreatedBy("Cuong Ngo");

        thorRagnorok.getMovieCinemas().add(movieCinema_thorRagnorok);


        MovieCinema movieCinema_jigSaw_cgv = new MovieCinema();
        movieCinema_jigSaw_cgv.setMovie(jigSaw);
        movieCinema_jigSaw_cgv.setCinema(cvg);
        movieCinema_jigSaw_cgv.setCreatedDate(new Date());
        movieCinema_jigSaw_cgv.setCreatedBy("Van Cuong Ngo");

        MovieCinema movieCinema_jigSaw_vicom = new MovieCinema();
        movieCinema_jigSaw_vicom.setMovie(jigSaw);
        movieCinema_jigSaw_vicom.setCinema(vincom);
        movieCinema_jigSaw_vicom.setCreatedDate(new Date());
        movieCinema_jigSaw_vicom.setCreatedBy("Ngo Van Cuong");

        jigSaw.getMovieCinemas().add(movieCinema_jigSaw_cgv);
        jigSaw.getMovieCinemas().add(movieCinema_jigSaw_vicom);

        movieService.save(thorRagnorok);
        movieService.save(jigSaw);


        return null;
    }
}
