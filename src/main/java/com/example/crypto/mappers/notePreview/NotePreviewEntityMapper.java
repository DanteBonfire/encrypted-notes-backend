package com.example.crypto.mappers.notePreview;

import com.example.crypto.models.notePreview.NotePreview;
import com.example.crypto.models.notePreview.NotePreviewEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.ERROR,
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    builder = @Builder(disableBuilder = true),
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NotePreviewEntityMapper {

    NotePreview fromEntity(NotePreviewEntity notePreviewEntity);

    NotePreviewEntity toEntity(NotePreview notePreview);
}
