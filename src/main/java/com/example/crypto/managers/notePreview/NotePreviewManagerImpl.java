package com.example.crypto.managers.notePreview;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.mappers.notePreview.NotePreviewEntityMapper;
import com.example.crypto.models.notePreview.NotePreview;
import com.example.crypto.repositories.notePreview.NotePreviewRepository;
import com.example.crypto.utils.StreamTools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NotePreviewManagerImpl implements NotePreviewManager{

    private final NotePreviewRepository notePreviewRepository;
    private final NotePreviewEntityMapper notePreviewEntityMapper;

    @Override
    public NotePreview save(NotePreview notePreview) {
        return notePreviewEntityMapper.fromEntity(
            notePreviewRepository.save(
                notePreviewEntityMapper.toEntity(notePreview)
            )
        );
    }

    @Override
    public List<NotePreview> getNotePreviews() {
        return StreamTools.toStream(notePreviewRepository.findAll())
            .map(notePreviewEntityMapper::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public NotePreview getNotePreviewById(long notePreviewId) throws NoteNotFoundException {
        return notePreviewEntityMapper.fromEntity(
            notePreviewRepository.findById(notePreviewId)
                .orElseThrow(() -> new NoteNotFoundException(MessageFormat.format("Cannot find note with id {0}", notePreviewId)))
        );
    }

    @Override
    public void deleteNotePreview(long notePreviewId) {
        notePreviewRepository.deleteById(notePreviewId);
    }
}
