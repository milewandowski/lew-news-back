package com.lew.eventtimeline.type.domain.port;

import com.lew.eventtimeline.type.domain.Type;

public interface GetDbTypeUseCase {

    Type get(Long id);
}
