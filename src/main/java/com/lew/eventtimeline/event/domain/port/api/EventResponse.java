package com.lew.eventtimeline.event.domain.port.api;

import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class EventResponse {

    Long id;
    String name;
    String shortDesc;
    String longDesc;
    String imageUrl;
    LocalDate startDate;
    LocalDate endDate;
    TypeDto type;
}
