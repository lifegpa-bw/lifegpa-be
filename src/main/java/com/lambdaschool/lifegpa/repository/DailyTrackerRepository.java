package com.lambdaschool.lifegpa.repository;

import com.lambdaschool.lifegpa.models.DailyTracker;
import org.springframework.data.repository.CrudRepository;

public interface DailyTrackerRepository extends CrudRepository<DailyTracker, Long> {
}
