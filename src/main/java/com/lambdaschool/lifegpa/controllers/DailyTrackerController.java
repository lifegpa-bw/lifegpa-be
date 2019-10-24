package com.lambdaschool.lifegpa.controllers;

import com.lambdaschool.lifegpa.models.DailyTracker;
import com.lambdaschool.lifegpa.services.DailyTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class DailyTrackerController {


    @Autowired
    DailyTrackerService dailyTrackerService;

    @PostMapping("/")
    private void logActivity(@RequestBody DailyTracker dailyTracker){
        dailyTrackerService.save(dailyTracker);
    }


}
