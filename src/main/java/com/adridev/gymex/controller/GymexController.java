package com.adridev.gymex.controller;

import com.adridev.gymex.entity.Day;
import com.adridev.gymex.entity.Routine;
import com.adridev.gymex.entity.User;
import com.adridev.gymex.entity.Week;
import com.adridev.gymex.models.ValidationError;
import com.adridev.gymex.services.RoutineService;
import com.adridev.gymex.services.UserService;
import com.adridev.gymex.services.WeekService;
import com.adridev.gymex.services.ZoneDateTimeService;
import com.adridev.gymex.validation.UserValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@RestController
@Validated
@RequestMapping(path = "/gymex")
public class GymexController {
    private final RoutineService routineService;
    private final WeekService weekService;;
    private final UserService userService;
    private final ZoneDateTimeService zoneDateTimeService;


    @Autowired
    public GymexController(RoutineService routineService, WeekService weekService, UserService userService, ZoneDateTimeService zoneDateTimeService) {
        this.routineService = routineService;
        this.weekService = weekService;
        this.userService = userService;
        this.zoneDateTimeService = zoneDateTimeService;
    }

    @PostMapping("user/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User newUser) {
        //userValidation.validate(newUser, result);
        if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            ValidationError error = new ValidationError();
            error.setField("confirmPassword");
            error.setMessage("Las contraseñas no coinciden");
            return new ResponseEntity<>(List.of(error), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(userService.register(newUser));
    }

    @GetMapping("user/{name}/{password}")
    public CompletableFuture<ResponseEntity<User>> getUserById(@PathVariable String name, @PathVariable String password) {
        return CompletableFuture.completedFuture(
                userService.getUserByNamePass(name, password)
                        .map(user -> ResponseEntity.ok().body(user))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @GetMapping("routines/{userId}")
    public CompletableFuture<ResponseEntity<List<Routine>>> getRoutines(@PathVariable UUID userId) {

        return CompletableFuture.completedFuture(
                routineService.getAllRoutines(userId)
                        .map(routines -> ResponseEntity.ok().body(routines))
                        .orElse(ResponseEntity.notFound().build())
        );

    }

    @PutMapping("routines/{userId}")
    public CompletableFuture<ResponseEntity<Routine>> putRoutine(@PathVariable String userId, @RequestBody Routine editedRoutine) {
        return CompletableFuture.completedFuture(
                routineService.editRoutine(userId, editedRoutine)
                        .map(routine -> ResponseEntity.ok().body(routine))
                        .orElse(ResponseEntity.notFound().build())
        );
    }
    @PutMapping ("{userId}/routines/associate/{dayId}")
    public CompletableFuture<ResponseEntity<Day>> putWeekDayRoutine(@PathVariable String userId, @PathVariable Integer dayId, @RequestBody Routine editedRoutine) {
        editedRoutine.setGeneral(false);
        return CompletableFuture.completedFuture(
                Optional
                        .of(weekService.editWeekDayRoutine(userId, dayId, editedRoutine))
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @DeleteMapping ("{userId}/routines/desassociate/{dayId}")
    public CompletableFuture<ResponseEntity<Day>> removeWeekDayRoutine(@PathVariable String userId, @PathVariable Integer dayId) {
        return CompletableFuture.completedFuture(
                Optional
                        .of(weekService.desAssociateWeekDayRoutine(userId, dayId))
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.notFound().build())
        );
    }


    @PostMapping("routines/{userId}")
    public CompletableFuture<ResponseEntity<Routine>> postRoutine(@PathVariable UUID userId, @RequestBody Routine newRoutine) {
        newRoutine.setUserId(userId);
        newRoutine.setGeneral(true);
        newRoutine.setCreatedDate(zoneDateTimeService.getZoneDateTime("Europe/Madrid"));
        return CompletableFuture.completedFuture(
                Optional
                        .ofNullable(routineService.postRoutine(userId, newRoutine))
                        .map(routine -> ResponseEntity.ok().body(routine))
                        .orElse(ResponseEntity.badRequest().build())
        );
    }

    @DeleteMapping("routines/{userId}/{routineId}")
    public CompletableFuture<ResponseEntity<Void>> deleteRoutine(@PathVariable String userId, @PathVariable UUID routineId) {
        routineService.deleteRoutine(userId, routineId);
        return CompletableFuture.completedFuture(ResponseEntity.ok().build());

    }

    @GetMapping("weeks/{userId}")
    public CompletableFuture<ResponseEntity<List<Week>>> getWeeks(@PathVariable UUID userId) {
        return CompletableFuture.completedFuture(
                weekService.getAllWeeks(userId)
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @GetMapping("weeks/{userId}/{weekId}")
    public CompletableFuture<ResponseEntity<Week>> getWeekById(@PathVariable String userId, @PathVariable UUID weekId) {
        return CompletableFuture.completedFuture(
                weekService.getDBWeekById(userId, weekId)
                        .map(week -> ResponseEntity.ok().body(week))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @PutMapping ("weeks/{userId}")
    public CompletableFuture<ResponseEntity<Week>> putWeek(@PathVariable String userId, @RequestBody Week editedWeek) {
        return CompletableFuture.completedFuture(
                Optional
                        .of(weekService.editWeek(userId, editedWeek))
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.notFound().build())
        );
    }

    @PostMapping("weeks/{userId}")
    public CompletableFuture<ResponseEntity<Week>> postWeek(@PathVariable UUID userId, @RequestBody Week newWeek) {
        newWeek.setUserId(userId);
        newWeek.setCreatedDate(zoneDateTimeService.getZoneDateTime("Europe/Madrid"));
        return CompletableFuture.completedFuture(
                Optional
                        .of(weekService.postNewWeek(userId, newWeek))
                        .map(weeks -> ResponseEntity.ok().body(weeks))
                        .orElse(ResponseEntity.badRequest().build())
        );
    }

    @DeleteMapping("weeks/{userId}/{weekId}")
    public CompletableFuture<ResponseEntity<Void>> deleteWeek(@PathVariable String userId, @PathVariable UUID weekId) {
        /*int response = weekService.deleteWeek(userId, weekId);
        if (response == 0) {
            return CompletableFuture.completedFuture(ResponseEntity.ok().build());
        }
        return CompletableFuture.completedFuture(ResponseEntity.notFound().build());*/
        weekService.deleteWeek(userId, weekId);
        return CompletableFuture.completedFuture(ResponseEntity.ok().build());
    }
}