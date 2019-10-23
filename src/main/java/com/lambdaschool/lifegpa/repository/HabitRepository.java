package com.lambdaschool.lifegpa.repository;

import com.lambdaschool.lifegpa.models.Habit;

import org.springframework.data.repository.CrudRepository;



public interface HabitRepository extends CrudRepository<Habit, Long> {


}
