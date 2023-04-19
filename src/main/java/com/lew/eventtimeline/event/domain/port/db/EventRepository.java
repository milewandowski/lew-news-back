package com.lew.eventtimeline.event.domain.port.db;

import com.lew.eventtimeline.event.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE" +
            " (:startDate is null or e.startDate >= :startDate) and (:endDate is null or e.endDate >= :endDate)")
    Page<Event> findAllByStartDateAndEndDate(@Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate,
                                             Pageable pageable);
}
