package com.example.crypto.sevices.notePreview;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.managers.notePreview.NotePreviewManager;
import com.example.crypto.models.notePreview.NotePreview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotePreviewServiceImpl implements NotePreviewService {

    private final NotePreviewManager notePreviewManager;

    @Override
    public NotePreview createNotePreview(NotePreview notePreview) {
        return notePreviewManager.save(notePreview);
    }

    @Override
    public List<NotePreview> getNotePreviews() {
        return notePreviewManager.getNotePreviews();
    }

    @Override
    public NotePreview getNotePreviewById(long notePreviewId) throws NoteNotFoundException {
        return notePreviewManager.getNotePreviewById(notePreviewId);
    }

    @Override
    public NotePreview updateNotePreview(NotePreview notePreview) throws NoteNotFoundException {
        return notePreviewManager.save(notePreview);
    }

    @Override
    public void deleteNotePreview(long notePreviewId) {
        notePreviewManager.deleteNotePreview(notePreviewId);
    }
}
