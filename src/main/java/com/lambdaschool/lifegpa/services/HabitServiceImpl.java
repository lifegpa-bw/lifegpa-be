package com.lambdaschool.lifegpa.services;

import com.lambdaschool.lifegpa.exceptions.ResourceNotFoundException;
import com.lambdaschool.lifegpa.logging.Loggable;
import com.lambdaschool.lifegpa.models.Habit;
import com.lambdaschool.lifegpa.repository.HabitRepository;
import com.lambdaschool.lifegpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "habitService")
public class HabitServiceImpl implements HabitService {

    @Autowired
    HabitRepository habitrepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public List<Habit> findAll(Pageable pageable) {
        List<Habit> list = new ArrayList<>();
        habitrepos.findAll(pageable)
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Habit> findAllByUser() {
        List<Habit> habits = new ArrayList<>();
        habitrepos.findAll().iterator().forEachRemaining(habits::add);
        return habits;
    }

    @Override
    public Habit findHabitById(long id) {
        return habitrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit id " + id + " not found!"));
    }

    @Override
    public void delete(long id) {
        habitrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit id " + id + " not found!"));
        habitrepos.deleteById(id);
    }

    @Override
    public Habit save(Habit habit) {
        Habit newHabit = new Habit();
            newHabit.setDescription(habit.getDescription());
            newHabit.setScore(habit.getScore());
            newHabit.setGood_boolean(habit.isGood_boolean());
            newHabit.setUser(habit.getUser());

            return habitrepos.save(newHabit);

    }

    @Override
    public Habit update(Habit habit, long id) {
        Habit currentHabit = findHabitById(id);

        if (habit.getDescription() != null)
        {
            currentHabit.setDescription(habit.getDescription());
        }

        if (habit.getScore() != 0)
        {
            currentHabit.setScore(habit.getScore());
        }

        if (habit.isGood_boolean() != false)
        {
            currentHabit.setGood_boolean(habit.isGood_boolean());
        }

        if (habit.getUser() != null)
        {
            currentHabit.setUser(habit.getUser());
        }

        return habitrepos.save(currentHabit);
    }
}

// this.description = description;
//        this.score = score;
//        this.good_boolean = good_boolean;
//        this.user = user;
