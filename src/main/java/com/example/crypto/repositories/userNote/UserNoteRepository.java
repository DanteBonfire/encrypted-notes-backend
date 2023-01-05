package com.example.crypto.repositories.userNote;

import com.example.crypto.models.userNote.UserNoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNoteRepository extends CrudRepository<UserNoteEntity, Long> {
    List<UserNoteEntity> findAllByUserId(long userId);
}
