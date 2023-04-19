package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.common.exception.EventNotFoundException;
import com.lew.eventtimeline.event.domain.port.api.DeleteEventUseCase;
import com.lew.eventtimeline.event.domain.port.db.EventRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteEventService implements DeleteEventUseCase {

    EventRepository eventRepository;

    @Override
    public void delete(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        eventRepository.delete(event);
    }
}
