package com.lew.eventtimeline.type.domain;

import com.lew.eventtimeline.common.exception.TypeNotFoundException;
import com.lew.eventtimeline.type.domain.port.api.DeleteTypeUseCase;
import com.lew.eventtimeline.type.domain.port.db.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DeleteTypeService implements DeleteTypeUseCase {

    TypeRepository typeRepository;

    @Override
    public void delete(Long id) {
        Type type = typeRepository.findById(id).orElseThrow(() -> new TypeNotFoundException(id));

        typeRepository.delete(type);
    }
}
