package com.example.crypto.managers.note;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.models.note.Note;

import java.util.List;

public interface NoteManager {

    /**
     * Returns updated note.
     *
     * @param note specifies a note
     * @return updated note
     */
    Note save(Note note);

    /**
     * Returns all notes
     *
     * @return all notes
     */
    List<Note> getNotes();

    /**
     * Returns a note for requested an identifier of a note
     *
     * @param noteId specifies an identifier of a note
     * @return a note for requested an identifier of note
     * @throws NoteNotFoundException when user not found
     */
    Note getNote(long noteId) throws NoteNotFoundException;

    /**
     * Removes a note for requested an identifier of a note
     *
     * @param noteId specifies an identifier of a note
     */
    void deleteNote(long noteId);
}
