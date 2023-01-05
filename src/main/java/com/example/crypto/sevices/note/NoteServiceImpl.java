package com.example.crypto.sevices.note;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.managers.note.NoteManager;
import com.example.crypto.models.note.Note;
import com.example.crypto.models.userNote.UserNote;
import com.example.crypto.models.userNote.UserNoteAccess;
import com.example.crypto.sevices.userNote.UserNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService{

    private final NoteManager noteManager;
    private final RandomWordService randomWordService;
    private final EncryptDecryptService encryptDecryptService;

    private  final UserNoteService userNoteService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Note createNote(Note note) {
        String randomWord = randomWordService.createRandomWord(10);
        String privateKeyword = note.getKeyword();
        privateKeyword += randomWord;

        note.setText(encryptDecryptService.encrypt(note.getText(), privateKeyword));
        note.setKeyword(randomWord);
        return noteManager.save(note);
    }


    @Override
    public Note createLinkedNote(Note note, long userId) {
        String randomWord = randomWordService.createRandomWord(10);
        String privateKeyword = note.getKeyword();
        privateKeyword += randomWord;

        note.setText(encryptDecryptService.encrypt(note.getText(), privateKeyword));
        note.setKeyword(randomWord);

        userNoteService.createUserNote(UserNote.builder()
                .userId(userId)
                .noteId(noteManager.save(note).getId())
                .access(UserNoteAccess.OWNER)
                .build());
        return note;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Note> getNotes() {
        return noteManager.getNotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Note getNoteById(long noteId) throws NoteNotFoundException {
        return noteManager.getNote(noteId);
    }


    @Override
    public Note getNoteByIdAndKeyword(long noteId, String keyword) throws NoteNotFoundException {

        Note privateNote = noteManager.getNote(noteId);
        keyword += privateNote.getKeyword();

        String s = privateNote.getText();
        s = encryptDecryptService.decrypt(s, keyword);

        privateNote.setText(s);

        return privateNote;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Note updateNote(Note noteToUpdate, String keyword) throws NoteNotFoundException {
        Note note = noteManager.getNote(noteToUpdate.getId());

        String privateKeyword = note.getKeyword();
        keyword += privateKeyword;

        noteToUpdate.setText(encryptDecryptService.encrypt(noteToUpdate.getText(), keyword));
        noteToUpdate.setKeyword(privateKeyword);
        return noteManager.save(noteToUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNote(long noteId) {
        noteManager.deleteNote(noteId);
    }
}
