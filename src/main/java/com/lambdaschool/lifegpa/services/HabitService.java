package com.lambdaschool.lifegpa.services;


import com.lambdaschool.lifegpa.models.Habit;

import java.util.List;

public interface HabitService {

    List<Habit> findAll();

    Habit findHabitById(long id);

    void delete (long id);

    Habit save(Habit habit);

    Habit findByName(String name);

    Habit update(long id, Habit habit);
}
