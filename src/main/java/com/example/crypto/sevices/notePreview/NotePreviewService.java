package com.example.crypto.sevices.notePreview;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.models.notePreview.NotePreview;

import java.util.List;

public interface NotePreviewService {

    NotePreview createNotePreview (NotePreview notePreview);

    List<NotePreview> getNotePreviews();

    NotePreview getNotePreviewById(long notePreviewId) throws NoteNotFoundException;

    NotePreview updateNotePreview(NotePreview notePreview) throws NoteNotFoundException;

    void deleteNotePreview(long notePreviewId);
}
