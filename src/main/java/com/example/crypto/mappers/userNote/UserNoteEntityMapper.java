package com.example.crypto.mappers.userNote;

import com.example.crypto.models.userNote.UserNote;
import com.example.crypto.models.userNote.UserNoteEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.ERROR,
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    builder = @Builder(disableBuilder = true),
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserNoteEntityMapper {

    UserNote fromEntity(UserNoteEntity userNoteEntity);

    UserNoteEntity toEntity(UserNote userNote);
}
