package com.lew.eventtimeline.type.domain.port.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeDto {

    Long id;

    @NotBlank
    @Size(min = 1, max = 256)
    String name;

    @NotBlank
    @Size(min = 1, max = 256)
    String color;
}
