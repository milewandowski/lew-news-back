package com.lew.eventtimeline.type.domain;

import com.lew.eventtimeline.common.exception.TypeNotFoundException;
import com.lew.eventtimeline.type.domain.port.GetDbTypeUseCase;
import com.lew.eventtimeline.type.domain.port.db.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class GetDbTypeService implements GetDbTypeUseCase {

    TypeRepository typeRepository;

    @Override
    public Type get(Long id) {
        return typeRepository.findById(id).orElseThrow(() -> new TypeNotFoundException(id));
    }
}
