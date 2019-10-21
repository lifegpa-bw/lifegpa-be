//package com.lambdaschool.lifegpa.services;
//
//import com.lambdaschool.lifegpa.logging.Loggable;
//import com.lambdaschool.lifegpa.models.Habit;
//import com.lambdaschool.lifegpa.repository.HabitRepository;
//import com.lambdaschool.lifegpa.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.lambdaschool.lifegpa.services.HabitService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Loggable
//@Service(value = "habitService")
//public class HabitServiceImpl implements HabitService {
//
//    @Autowired
//    HabitRepository habitrepos;
//
//    @Autowired
//    UserRepository userrepos;
//
//    @Override
//    public List<Habit> returnAllHabits() {
//        List<Habit> habits = new ArrayList<>();
//        habitrepos.findAll().iterator().forEachRemaining(habits::add);
//        return habits;
//    }
//}
