package com.example.crypto.mappers.notePreview;

import com.example.crypto.models.notePreview.NotePreview;
import com.example.crypto.models.notePreview.NotePreviewRequest;
import com.example.crypto.models.notePreview.NotePreviewResponse;
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
public interface NotePreviewMapper {

    @Mapping(target = "id", ignore = true)
    NotePreview fromRequest(NotePreviewRequest notePreviewRequest);

    @Mapping(target = "id", source = "notePreviewId")
    NotePreview fromRequest(NotePreviewRequest notePreviewRequest, long notePreviewId);

    NotePreviewResponse toResponse(NotePreview notePreview);
}
