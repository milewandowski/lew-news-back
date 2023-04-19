package com.lew.eventtimeline.event.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.CreateEventUseCase;
import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.event.domain.port.api.EventRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateEventController {

    CreateEventUseCase createEventUseCase;

    @Operation(summary = "Create new event")
    @ApiResponse(responseCode = "200", description = "Event created successfully")
    @PostMapping(PathUtil.EVENT)
    public ResponseEntity<EventResponse> create(@Valid @RequestBody EventRequest eventRequest) {

        return ResponseEntity.ok(createEventUseCase.create(eventRequest));
    }
}
