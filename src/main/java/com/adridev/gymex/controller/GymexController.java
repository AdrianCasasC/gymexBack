package com.adridev.gymex.controller;

import com.adridev.gymex.models.Routine;
import com.adridev.gymex.models.Week;
import com.adridev.gymex.services.RoutineService;
import com.adridev.gymex.services.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/gymex")
public class GymexController {
    RoutineService routineService;
    WeekService weekService;

    @Autowired
    public GymexController(RoutineService routineService, WeekService weekService) {
        this.routineService = routineService;
        this.weekService = weekService;

    }

    @GetMapping("routines/{userId}")
    public CompletableFuture<ResponseEntity<List<Routine>>> getRoutines(@PathVariable String userId) {
        return CompletableFuture.completedFuture(
                Optional
                        .of(routineService.getAllRoutines(userId))
                        .map(routines -> ResponseEntity.ok().body(routines))
                        .orElse(ResponseEntity.notFound().build())
        );

    }

    @GetMapping("weeks/{userId}")
    public CompletableFuture<ResponseEntity<List<Week>>> getWeeks(@PathVariable String userId) {
        return CompletableFuture.completedFuture(
                Optional
                        .of(weekService.getAllWeeks(userId))
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.notFound().build())
        );
    }
}