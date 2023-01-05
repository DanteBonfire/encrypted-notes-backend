package com.example.crypto.mappers.note;

import com.example.crypto.models.note.Note;
import com.example.crypto.models.note.NoteEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.ERROR,
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    builder = @Builder(disableBuilder = true),
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NoteEntityMapper {

   Note fromEntity(NoteEntity noteEntity);

   NoteEntity toEntity(Note note);
}
