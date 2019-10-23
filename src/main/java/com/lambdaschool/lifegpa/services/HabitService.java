package com.lambdaschool.lifegpa.services;


import com.lambdaschool.lifegpa.models.Habit;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HabitService {

    List<Habit> findAll(Pageable pageable);

    List<Habit> findAllByUser();

    Habit findHabitById(long id);

    void delete (long id);

    Habit save(Habit habit);

    Habit update(Habit habit, long id);
}
