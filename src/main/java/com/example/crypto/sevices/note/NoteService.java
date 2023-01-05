package com.example.crypto.sevices.note;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.models.note.Note;

import java.util.List;

public interface NoteService {
    /**
     * Returns created note.
     *
     * @param note specifies a note
     * @return created note
     */
    Note createNote(Note note);

    Note createLinkedNote(Note note, long userId);

    /**
     * Returns all notes
     *
     * @return all notes
     */
    List<Note> getNotes();

    /**
     * Returns a note for requested identifier of a note
     *
     * @param noteId specifies an identifier of a note
     * @return a note for requested identifier of a note
     * @throws NoteNotFoundException when note not found
     */
    Note getNoteById(long noteId) throws NoteNotFoundException;

    Note getNoteByIdAndKeyword(long noteId, String keyword) throws NoteNotFoundException;

    /**
     * Returns updated note
     *
     * @param note specifies a note
     * @return updated note
     * @throws NoteNotFoundException when note not found
     */
    Note updateNote(Note note, String keyword) throws  NoteNotFoundException;

    /**
     * Removes a note for requested identifier of a note
     *
     * @param noteId specifies an identifier of a note
     */
    void deleteNote(long noteId);
}
