package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.common.exception.EventNotFoundException;
import com.lew.eventtimeline.event.domain.mapper.EventMapper;
import com.lew.eventtimeline.event.domain.port.api.EventRequest;
import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.event.domain.port.api.UpdateEventUseCase;
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
public class UpdateEventService implements UpdateEventUseCase {

    EventRepository eventRepository;
    GetDbTypeUseCase getDbTypeUseCase;

    @Override
    public EventResponse update(EventRequest eventRequest, Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        Type type = getDbTypeUseCase.get(eventRequest.getTypeId());

        Event updatedEvent = EventMapper.INSTANCE.eventRequestToEvent(eventRequest, type);
        updatedEvent.setId(event.getId());

        return EventMapper.INSTANCE.eventToEventResponse(eventRepository.save(updatedEvent));
    }
}
