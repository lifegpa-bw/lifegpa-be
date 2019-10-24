package com.lambdaschool.lifegpa.services;


import com.lambdaschool.lifegpa.models.DailyTracker;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DailyTrackerService {

    List<DailyTracker> findAll(Pageable pageable);

    List<DailyTracker> findAll();

    DailyTracker findDailyTrackerById(long id);

    void delete (long id);

    DailyTracker save(DailyTracker dailyTracker);

    DailyTracker update(DailyTracker dailyTracker, long id);

}
