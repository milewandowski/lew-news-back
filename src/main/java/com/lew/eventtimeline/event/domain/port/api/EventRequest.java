package com.lew.eventtimeline.event.domain.port.api;

import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class EventRequest {

    @NotNull
    Long typeId;

    @NotBlank
    @Size(min = 1, max = 256)
    String name;

    @NotBlank
    @Size(min = 1, max = 256)
    String shortDesc;

    @NotBlank
    @Size(min = 1, max = 1024)
    String longDesc;

    @NotBlank
    @Size(min = 1, max = 512)
    String imageUrl;

    @NotNull
    LocalDate startDate;

    LocalDate endDate;
}
