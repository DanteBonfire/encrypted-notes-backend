package com.example.crypto.mappers.user;

import com.example.crypto.models.user.User;
import com.example.crypto.models.user.UserRequest;
import com.example.crypto.models.user.UserResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.ERROR,
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    builder = @Builder(disableBuilder = true),
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User fromRequest(UserRequest userRequest);

    @Mapping(target = "id", source = "userId")
    User fromRequest(UserRequest userRequest, long userId);

    UserResponse toResponse(User user);
}
