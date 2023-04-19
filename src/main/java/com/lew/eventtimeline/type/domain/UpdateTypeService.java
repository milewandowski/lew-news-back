package com.lew.eventtimeline.type.domain;

import com.lew.eventtimeline.common.exception.TypeNotFoundException;
import com.lew.eventtimeline.type.domain.mapper.TypeMapper;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import com.lew.eventtimeline.type.domain.port.api.UpdateTypeUseCase;
import com.lew.eventtimeline.type.domain.port.db.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateTypeService implements UpdateTypeUseCase {

    TypeRepository typeRepository;

    @Override
    public TypeDto update(TypeDto typeDto, Long id) {
        Type type = typeRepository.findById(id).orElseThrow(() -> new TypeNotFoundException(id));

        Type updatedType = TypeMapper.INSTANCE.typeDtoToType(typeDto);
        updatedType.setId(type.getId());

        return TypeMapper.INSTANCE.typeToTypeDto(typeRepository.save(updatedType));
    }
}
