package com.lew.eventtimeline.user.domain.mapper;

import com.lew.eventtimeline.user.domain.User;
import com.lew.eventtimeline.user.domain.port.api.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse userToUserDto(User user);
}

