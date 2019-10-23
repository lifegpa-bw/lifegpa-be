package com.lambdaschool.lifegpa.repository;

import com.lambdaschool.lifegpa.models.DailyTracker;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DailyTrackerRepository extends PagingAndSortingRepository<DailyTracker, Long> {
}
