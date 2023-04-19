package com.lew.eventtimeline.event.domain.port.api;

public interface CreateEventUseCase {

    EventResponse create(EventRequest eventRequest);
}
