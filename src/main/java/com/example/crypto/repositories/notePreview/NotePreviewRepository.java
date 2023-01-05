package com.example.crypto.repositories.notePreview;

import com.example.crypto.models.notePreview.NotePreviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotePreviewRepository extends CrudRepository<NotePreviewEntity, Long> {

}
