package com.lambdaschool.lifegpa.services;

import com.lambdaschool.lifegpa.exceptions.ResourceNotFoundException;
import com.lambdaschool.lifegpa.logging.Loggable;
import com.lambdaschool.lifegpa.models.DailyTracker;
import com.lambdaschool.lifegpa.models.Habit;
import com.lambdaschool.lifegpa.repository.DailyTrackerRepository;
import com.lambdaschool.lifegpa.repository.HabitRepository;
import com.lambdaschool.lifegpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Loggable
@Service(value = "dailyTrackerService")
public class DailyTrackerServiceImpl implements DailyTrackerService {

    @Autowired
    DailyTrackerRepository dailytrackerrepos;

    @Autowired
    HabitRepository habitrepos;

    @Autowired
    UserRepository userrepos;

    // Find all Daily Tracker
//    @Override
    public List<DailyTracker> findAll(Pageable pageable) {
        List<DailyTracker> list = new ArrayList<>();
        dailytrackerrepos.findAll(pageable)
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    // find Daily Tracker by id
//    @Override
    public List<DailyTracker> findDailyTrackerById() {
        List<DailyTracker> dailytrackers = new ArrayList<>();
        dailytrackerrepos.findAll().iterator().forEachRemaining(dailytrackers::add);
        return dailytrackers;
    }

//    @Override
//    public Habit findHabitById(long id) {
//        return habitrepos.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Habit id " + id + " not found!"));
//    }

    @Override
    public List<DailyTracker> findAll(java.awt.print.Pageable pageable) {
        return null;
    }

    @Override
    public DailyTracker findDailyTrackerById(long id) {
        return null;
    }

    // delete
    @Override
    public void delete(long id) {
        habitrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DailyTracker id " + id + " not found!"));
        habitrepos.deleteById(id);
    }

    // save
    @Override
    public DailyTracker save(DailyTracker dailyTracker) {
        return dailytrackerrepos.save(dailyTracker);
    }

    // update
    @Override
    public DailyTracker update(DailyTracker dailytracker, long id) {
        DailyTracker currentDailyTracker = findDailyTrackerById(id);

        if (dailytracker.getDatetime() != null) {
            currentDailyTracker.setDatetime(dailytracker.getDatetime());
        }

        if (dailytracker.getUser() != null) {
            currentDailyTracker.setUser(dailytracker.getUser());
        }

        if (dailytracker.getHabit() != null) {
            currentDailyTracker.setHabit(dailytracker.getHabit());
        }

        return dailytrackerrepos.save(currentDailyTracker);
    }
}
