package com.lew.eventtimeline.event.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.EventRequest;
import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.event.domain.port.api.UpdateEventUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateEventController {

    UpdateEventUseCase updateEventUseCase;

    @Operation(summary = "Update existing event")
    @ApiResponse(responseCode = "200", description = "Event updated successfully")
    @PutMapping(PathUtil.EVENT_ID)
    public ResponseEntity<EventResponse> update(@Valid @RequestBody EventRequest eventRequest,
                                                @Parameter(description = "Id of event which will be updated")
                                                @PathVariable Long id) {

        return ResponseEntity.ok(updateEventUseCase.update(eventRequest, id));
    }
}
