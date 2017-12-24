package com.codeko.cinemaapi.repository;

import com.codeko.cinemaapi.repository.entity.SchedulerJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<SchedulerJob, Long> {
}
