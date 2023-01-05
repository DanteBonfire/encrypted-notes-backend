package com.example.crypto.sevices.userNote;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.exceptions.userNote.UserNoteNotFoundException;
import com.example.crypto.managers.note.NoteManager;
import com.example.crypto.managers.user.UserManager;
import com.example.crypto.managers.userNote.UserNoteManager;
import com.example.crypto.models.note.Note;
import com.example.crypto.models.user.User;
import com.example.crypto.models.userNote.UserNote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserNoteServiceImpl  implements UserNoteService {

    private final UserNoteManager userNoteManager;
//    private final UserManager userManager;
//    private final NoteManager noteManager;

    @Override
    public UserNote createUserNote(UserNote userNote) {
        return userNoteManager.save(userNote);
    }

    @Override
    public List<UserNote> getUserNotes() {
        return userNoteManager.getUserNotes();
    }

    @Override
    public UserNote getUserNoteById(long userNoteId) throws UserNoteNotFoundException {
        return userNoteManager.getUserNote(userNoteId);
    }

    @Override
    public List<UserNote> getUserNotesByUserId(long userId) throws UserNotFoundException {
        return userNoteManager.getUserNotesByUserId(userId);
    }

    @Override
    public UserNote updateUserNote(UserNote userNote) throws UserNoteNotFoundException {
        return userNoteManager.save(userNote);
    }

    @Override
    public void deleteUserNote(long userNoteId) {
        userNoteManager.deleteUserNote(userNoteId);
    }

}
