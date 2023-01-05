package com.example.crypto.managers.userNote;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.exceptions.userNote.UserNoteNotFoundException;
import com.example.crypto.models.userNote.UserNote;

import java.util.List;

public interface UserNoteManager {

    UserNote save(UserNote userNote);

    List<UserNote> getUserNotes();

    UserNote getUserNote(long userNoteId) throws UserNoteNotFoundException;

    List<UserNote> getUserNotesByUserId(long userId) throws UserNotFoundException;
    void deleteUserNote(long userNoteId);
}
