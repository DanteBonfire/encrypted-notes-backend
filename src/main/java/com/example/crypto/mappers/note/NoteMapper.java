package com.example.crypto.mappers.note;

import com.example.crypto.models.note.Note;
import com.example.crypto.models.note.NoteRequest;
import com.example.crypto.models.note.NoteResponse;
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
public interface NoteMapper {

    @Mapping(target = "id", ignore = true)
    Note fromRequest(NoteRequest noteRequest);

    @Mapping(target = "id", source = "noteId")
    Note fromRequest(NoteRequest noteRequest, long noteId);


    NoteResponse toResponse(Note note);

}
