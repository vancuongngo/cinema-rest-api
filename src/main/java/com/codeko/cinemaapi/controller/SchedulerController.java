package com.codeko.cinemaapi.controller;

import com.codeko.cinemaapi.service.SchedulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerController extends BaseController {

    private SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping(value = "/job")
    public ResponseEntity<String> triggerSchedulerJob() {
        return ResponseEntity.ok().body(schedulerService.triggerSchedulerJob());
    }

    @GetMapping(value = "/many-to-many")
    public ResponseEntity<String> triggerManyToManySavingProcess() {
        return ResponseEntity.ok().body(schedulerService.triggerManyToManySavingProcess());
    }
}
