package com.lew.eventtimeline.event.domain.port.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface FindEventsPageUseCase {

    Page<EventResponse> find(LocalDate fromStartDate, LocalDate fromEndDate, Pageable pageable);
}
