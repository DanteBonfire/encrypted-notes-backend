package com.example.crypto.sevices.userNote;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.exceptions.userNote.UserNoteNotFoundException;
import com.example.crypto.models.note.Note;
import com.example.crypto.models.user.User;
import com.example.crypto.models.userNote.UserNote;

import java.util.List;

public interface UserNoteService {

    UserNote createUserNote(UserNote userNote);

    List<UserNote> getUserNotes();

    UserNote getUserNoteById(long userNoteId) throws UserNoteNotFoundException;

    List<UserNote> getUserNotesByUserId(long userId) throws UserNotFoundException;


    UserNote updateUserNote(UserNote userNote) throws UserNoteNotFoundException;

    void deleteUserNote(long userNoteId);

}
