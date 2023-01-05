package com.example.crypto.managers.userNote;

import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.exceptions.userNote.UserNoteNotFoundException;
import com.example.crypto.mappers.userNote.UserNoteEntityMapper;
import com.example.crypto.models.userNote.UserNote;
import com.example.crypto.repositories.userNote.UserNoteRepository;
import com.example.crypto.utils.StreamTools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserNoteManagerImpl implements UserNoteManager {

    private final UserNoteRepository userNoteRepository;
    private final UserNoteEntityMapper userNoteEntityMapper;

    @Override
    public UserNote save(UserNote userNote) {
        return userNoteEntityMapper.fromEntity(
            userNoteRepository.save(
                userNoteEntityMapper.toEntity(userNote)
            )
        );
    }

    @Override
    public List<UserNote> getUserNotes() {
        return StreamTools.toStream(userNoteRepository.findAll())
            .map(userNoteEntityMapper::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public UserNote getUserNote(long userNoteId) throws UserNoteNotFoundException {
        return userNoteEntityMapper.fromEntity(
            userNoteRepository.findById(userNoteId)
                .orElseThrow(() -> new UserNoteNotFoundException(MessageFormat.format("Cannot find {0}", userNoteId)))
        );
    }

    @Override
    public List<UserNote> getUserNotesByUserId(long userId) throws UserNotFoundException {
        return StreamTools.toStream(userNoteRepository.findAllByUserId(userId))
            .map(userNoteEntityMapper::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteUserNote(long userNoteId) {
        userNoteRepository.deleteById(userNoteId);
    }
}
