package com.lew.eventtimeline.type.domain.port.api;

public interface UpdateTypeUseCase {

    TypeDto update(TypeDto typeDto, Long id);
}
