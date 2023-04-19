package com.lew.eventtimeline.event.domain.port.api;

public interface GetEventUseCase {

    EventResponse get(Long id);
}
