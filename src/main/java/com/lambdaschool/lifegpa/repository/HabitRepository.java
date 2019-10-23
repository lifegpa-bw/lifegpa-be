package com.lambdaschool.lifegpa.repository;

import com.lambdaschool.lifegpa.models.Habit;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface HabitRepository extends PagingAndSortingRepository<Habit, Long> {


}
