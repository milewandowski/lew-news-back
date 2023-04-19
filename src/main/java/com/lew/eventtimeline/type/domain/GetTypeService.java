package com.lew.eventtimeline.type.domain;

import com.lew.eventtimeline.common.exception.TypeNotFoundException;
import com.lew.eventtimeline.type.domain.mapper.TypeMapper;
import com.lew.eventtimeline.type.domain.port.api.GetTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import com.lew.eventtimeline.type.domain.port.db.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetTypeService implements GetTypeUseCase {

    TypeRepository typeRepository;

    @Override
    public TypeDto get(Long id) {

        return typeRepository.findById(id)
                .map(TypeMapper.INSTANCE::typeToTypeDto)
                .orElseThrow(() -> new TypeNotFoundException(id));
    }
}
