package com.codeko.cinemaapi.service;

import com.codeko.cinemaapi.repository.SchedulerRepository;
import com.codeko.cinemaapi.repository.entity.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public String triggerSchedulerJob() {
        SchedulerJob schedulerJob = SchedulerJob.builder()
                .created(LocalDateTime.now())
                .build();
        schedulerJob = this.save(schedulerJob);


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
                .showtimeSystem(md4x)
                .build());

        return "Success";
    }

    private SchedulerJob save(SchedulerJob schedulerJob) {
        return this.schedulerRepository.save(schedulerJob);
    }
}
