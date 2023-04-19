package com.lew.eventtimeline.type.domain;

import com.lew.eventtimeline.type.domain.mapper.TypeMapper;
import com.lew.eventtimeline.type.domain.port.api.FindTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import com.lew.eventtimeline.type.domain.port.db.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FindTypeService implements FindTypeUseCase {

    TypeRepository typeRepository;

    @Override
    public List<TypeDto> find() {

        return typeRepository.findAll().stream()
                .map(TypeMapper.INSTANCE::typeToTypeDto)
                .toList();
    }
}
