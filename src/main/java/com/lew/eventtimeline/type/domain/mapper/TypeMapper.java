package com.lew.eventtimeline.type.domain.mapper;

import com.lew.eventtimeline.type.domain.Type;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TypeMapper {

    TypeMapper INSTANCE = Mappers.getMapper(TypeMapper.class);

    TypeDto typeToTypeDto(Type type);

    @Mapping(target = "id", ignore = true)
    Type typeDtoToType(TypeDto typeDto);
}
