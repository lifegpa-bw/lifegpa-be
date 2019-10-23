package com.lambdaschool.lifegpa.controllers;

import com.lambdaschool.lifegpa.logging.Loggable;
import com.lambdaschool.lifegpa.models.Habit;
import com.lambdaschool.lifegpa.models.User;
import com.lambdaschool.lifegpa.services.HabitService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Loggable
@RestController
@RequestMapping("/habits")
public class HabitController {
    private static final Logger logger = LoggerFactory.getLogger(HabitController.class);

    @Autowired
    private HabitService habitService;

    @ApiOperation(value = "returns all Habits by userid",
            response = User.class,
            responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",
            dataType = "integer",
            paramType = "query",
            value = "Results page you want to retrieve (0..N)"), @ApiImplicitParam(name = "size",
            dataType = "integer",
            paramType = "query",
            value = "Number of records per page."), @ApiImplicitParam(name = "sort",
            allowMultiple = true,
            dataType = "string",
            paramType = "query",
            value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})

    // GET request - localhost:2019/habits/habits
    @GetMapping(value = "/habits", produces = {"application/json"})
    public ResponseEntity<?> listAllHabitByUserId(HttpServletRequest request, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Habit> myHabits = habitService.findAll(pageable);
        return new ResponseEntity<>(myHabits, HttpStatus.OK);
    }

    // POST - adding a new habit
    // localhost:2019/habits/habit
    @PostMapping(value = "/habit",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewHabit(HttpServletRequest request,
                                        @Valid
                                        @RequestBody Habit newhabit) throws URISyntaxException {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        newhabit = habitService.save(newhabit);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newhabit.getHabitid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

}
