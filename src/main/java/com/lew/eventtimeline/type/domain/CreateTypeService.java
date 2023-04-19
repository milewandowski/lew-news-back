package com.lew.eventtimeline.type.domain;

import com.lew.eventtimeline.type.domain.mapper.TypeMapper;
import com.lew.eventtimeline.type.domain.port.api.CreateTypeUseCase;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import com.lew.eventtimeline.type.domain.port.db.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateTypeService implements CreateTypeUseCase {

    TypeRepository typeRepository;

    @Override
    public TypeDto create(TypeDto typeDto) {
        Type newType = typeRepository.save(TypeMapper.INSTANCE.typeDtoToType(typeDto));

        return TypeMapper.INSTANCE.typeToTypeDto(newType);
    }
}
