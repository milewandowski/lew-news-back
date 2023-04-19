package com.lew.eventtimeline.event.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.DeleteEventUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteEventController {

    DeleteEventUseCase deleteEventUseCase;

    @Operation(summary = "Delete event")
    @ApiResponse(responseCode = "200", description = "Event deleted successfully")
    @DeleteMapping(PathUtil.EVENT_ID)
    public ResponseEntity<?> delete(@PathVariable @Parameter(description = "Id of event to be deleted") Long id) {
        deleteEventUseCase.delete(id);

        return ResponseEntity.ok().build();
    }
}
