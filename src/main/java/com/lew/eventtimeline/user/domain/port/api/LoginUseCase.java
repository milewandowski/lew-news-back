package com.lew.eventtimeline.user.domain.port.api;

import org.springframework.http.ResponseEntity;

public interface LoginUseCase {

    ResponseEntity<UserResponse> login(UserRequest userDto);
}
