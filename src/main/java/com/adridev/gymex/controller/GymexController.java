package com.adridev.gymex.controller;

import com.adridev.gymex.models.Routine;
import com.adridev.gymex.models.Week;
import com.adridev.gymex.services.RoutineService;
import com.adridev.gymex.services.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMethod;

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
                routineService.getAllRoutines(userId)
                        .map(routines -> ResponseEntity.ok().body(routines))
                        .orElse(ResponseEntity.notFound().build())
        );

    }

    @PutMapping("routines/{userId}")
    public CompletableFuture<ResponseEntity<Routine>> putRoutine(@PathVariable String userId, @RequestBody Routine newRoutine) {
        return CompletableFuture.completedFuture(
                routineService.editRoutine(userId, newRoutine)
                        .map(routine -> ResponseEntity.ok().body(routine))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @PostMapping("routines/{userId}")
    public CompletableFuture<ResponseEntity<Routine>> postRoutine(@PathVariable String userId, @RequestBody Routine newRoutine) {
        return CompletableFuture.completedFuture(
                Optional
                        .ofNullable(routineService.postRoutine(userId, newRoutine))
                        .map(routine -> ResponseEntity.ok().body(routine))
                        .orElse(ResponseEntity.badRequest().build())
        );
    }

    @GetMapping("weeks/{userId}")
    public CompletableFuture<ResponseEntity<List<Week>>> getWeeks(@PathVariable String userId) {
        return CompletableFuture.completedFuture(
                weekService.getAllWeeks(userId)
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @PutMapping ("weeks/{userId}")
    public CompletableFuture<ResponseEntity<List<Week>>> putWeek(@PathVariable String userId, @RequestBody Week newWeek) {
        return CompletableFuture.completedFuture(
                Optional
                        .of(weekService.editWeek(userId, newWeek))
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @PostMapping("weeks/{userId}")
    public CompletableFuture<ResponseEntity<List<Week>>> postWeek(@PathVariable String userId, @RequestBody Week newWeek) {
        return CompletableFuture.completedFuture(
                Optional
                        .of(weekService.postNewWeek(userId, newWeek))
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.badRequest().build())
        );
    }
}