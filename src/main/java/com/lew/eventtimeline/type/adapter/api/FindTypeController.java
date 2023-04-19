package com.lew.eventtimeline.type.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.type.domain.port.api.FindTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.GetTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FindTypeController {

    FindTypeUseCase findTypeUseCase;
    GetTypeUseCase getTypeUseCase;

    @Operation(summary = "Get list of types")
    @ApiResponse(responseCode = "200", description = "List of types returned successfully")
    @GetMapping(PathUtil.TYPE)
    public ResponseEntity<List<TypeDto>> find() {

        return ResponseEntity.ok(findTypeUseCase.find());
    }

    @Operation(summary = "Get type by id")
    @ApiResponse(responseCode = "200", description = "Type returned successfully")
    @GetMapping(PathUtil.TYPE_ID)
    public ResponseEntity<TypeDto> get(@Parameter(description = "Id of wanted type") @PathVariable Long id) {

        return ResponseEntity.ok(getTypeUseCase.get(id));
    }
}
