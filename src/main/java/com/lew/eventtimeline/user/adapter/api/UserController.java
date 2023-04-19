package com.lew.eventtimeline.user.adapter.api;

import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.user.domain.port.api.ChangePasswordUseCase;
import com.lew.eventtimeline.user.domain.port.api.LoginUseCase;
import com.lew.eventtimeline.user.domain.port.api.UserResponse;
import com.lew.eventtimeline.user.domain.port.api.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/user")
public class UserController {

    LoginUseCase loginUseCase;
    ChangePasswordUseCase changePasswordUseCase;

    @Operation(summary = "Login and get JWT as a header")
    @ApiResponse(responseCode = "200", description = "Login successful",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserResponse.class))})
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody UserRequest userRequest) {

        return loginUseCase.login(userRequest);
    }

    @Operation(summary = "Change password for username")
    @ApiResponse(responseCode = "200", description = "Password changed successfully",
            content = {@Content})
    @PutMapping("/password/{username}")
    public ResponseEntity<?> changePassword(@Parameter(description = "Username of user who's password will be changed")
                                            @PathVariable String username,
                                            @Valid @RequestBody UserRequest userRequest) {
        changePasswordUseCase.change(username, userRequest);

        return ResponseEntity.ok().build();
    }
}
