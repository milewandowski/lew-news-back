package com.lew.eventtimeline.type.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import com.lew.eventtimeline.type.domain.port.api.UpdateTypeUseCase;
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
public class UpdateTypeController {

    UpdateTypeUseCase updateTypeUseCase;

    @Operation(summary = "Update existing type")
    @ApiResponse(responseCode = "200", description = "Type updated successfully")
    @PutMapping(PathUtil.TYPE_ID)
    public ResponseEntity<TypeDto> update(@Valid @RequestBody TypeDto typeDto,
                                          @Parameter(description = "Id of type which will be updated")
                                          @PathVariable Long id) {

        return ResponseEntity.ok(updateTypeUseCase.update(typeDto, id));
    }
}
