package com.example.crypto.managers.notePreview;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.models.notePreview.NotePreview;

import java.util.List;

public interface NotePreviewManager {

    NotePreview save(NotePreview notePreview);

    List<NotePreview> getNotePreviews();

    NotePreview getNotePreviewById(long notePreviewId) throws NoteNotFoundException;

    void deleteNotePreview(long notePreviewId);
}
