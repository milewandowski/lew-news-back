package com.lew.eventtimeline.event.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.event.domain.port.api.FindEventsPageUseCase;
import com.lew.eventtimeline.event.domain.port.api.GetEventUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FindEventController {

    FindEventsPageUseCase findEventsPageUseCase;
    GetEventUseCase getEventUseCase;

    @Operation(summary = "Get page of events")
    @ApiResponse(responseCode = "200", description = "Page of events returned successfully")
    @GetMapping(PathUtil.EVENT)
    public ResponseEntity<Page<EventResponse>> find(@RequestParam(name = "fromStartDate", required = false)
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                    LocalDate fromStartDate,
                                                    @RequestParam(name = "fromEndDate", required = false)
                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                    LocalDate fromEndDate,
                                                    @ParameterObject Pageable pageable) {

        return ResponseEntity.ok(findEventsPageUseCase.find(fromStartDate, fromEndDate, pageable));
    }

    @Operation(summary = "Get event by id")
    @ApiResponse(responseCode = "200", description = "Event returned successfully")
    @GetMapping(PathUtil.EVENT_ID)
    public ResponseEntity<EventResponse> get(@Parameter(description = "Id of wanted event") @PathVariable Long id) {

        return ResponseEntity.ok(getEventUseCase.get(id));
    }
}
