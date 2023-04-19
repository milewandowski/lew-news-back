package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.event.domain.mapper.EventMapper;
import com.lew.eventtimeline.event.domain.port.api.CreateEventUseCase;
import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.event.domain.port.api.EventRequest;
import com.lew.eventtimeline.event.domain.port.db.EventRepository;
import com.lew.eventtimeline.type.domain.Type;
import com.lew.eventtimeline.type.domain.port.GetDbTypeUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class CreateEventService implements CreateEventUseCase {

    EventRepository eventRepository;
    GetDbTypeUseCase getDbTypeUseCase;

    @Override
    public EventResponse create(EventRequest eventRequest) {
        Type type = getDbTypeUseCase.get(eventRequest.getTypeId());

        Event newEvent = eventRepository.save(EventMapper.INSTANCE.eventRequestToEvent(eventRequest, type));

        return EventMapper.INSTANCE.eventToEventResponse(newEvent);
    }
}
