package com.example.crypto.mappers.userNote;

import com.example.crypto.models.userNote.UserNote;
import com.example.crypto.models.userNote.UserNoteRequest;
import com.example.crypto.models.userNote.UserNoteResponse;
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
public interface UserNoteMapper {

    @Mapping(target = "id", ignore = true)
    UserNote fromRequest(UserNoteRequest userNoteRequest);

    @Mapping(target = "id", source = "userNoteId")
    UserNote fromRequest(UserNoteRequest userNoteRequest, long userNoteId);

    UserNoteResponse toResponse(UserNote userNote);
}
