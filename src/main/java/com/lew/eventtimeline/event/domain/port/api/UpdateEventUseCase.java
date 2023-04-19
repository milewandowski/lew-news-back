package com.lew.eventtimeline.event.domain.port.api;

public interface UpdateEventUseCase {

    EventResponse update(EventRequest eventResponse, Long id);
}
