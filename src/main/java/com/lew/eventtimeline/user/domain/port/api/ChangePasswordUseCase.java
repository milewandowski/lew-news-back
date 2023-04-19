package com.lew.eventtimeline.user.domain.port.api;

public interface ChangePasswordUseCase {

    void change(String username, UserRequest userRequest);
}
