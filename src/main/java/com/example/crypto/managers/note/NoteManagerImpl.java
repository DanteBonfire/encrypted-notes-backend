package com.example.crypto.managers.note;

import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.mappers.note.NoteEntityMapper;
import com.example.crypto.models.note.Note;
import com.example.crypto.repositories.note.NoteRepository;
import com.example.crypto.utils.StreamTools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NoteManagerImpl implements NoteManager{

    private final NoteRepository noteRepository;
    private final NoteEntityMapper noteEntityMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public Note save(Note note) {
        return noteEntityMapper.fromEntity(
            noteRepository.save(
                noteEntityMapper.toEntity(note)
            )
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Note> getNotes() {
        return StreamTools.toStream(noteRepository.findAll())
            .map(noteEntityMapper::fromEntity)
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Note getNote(long noteId) throws NoteNotFoundException {
        return noteEntityMapper.fromEntity(
            noteRepository.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(MessageFormat.format("Cannot find note with id {0}", noteId)))
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNote(long noteId) {noteRepository.deleteById(noteId);}
}
