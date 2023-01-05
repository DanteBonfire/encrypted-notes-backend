package com.example.crypto.controllers.notePreview;

import com.example.crypto.config.SwaggerConfig;
import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.mappers.notePreview.NotePreviewMapper;
import com.example.crypto.models.notePreview.NotePreviewRequest;
import com.example.crypto.models.notePreview.NotePreviewResponse;
import com.example.crypto.sevices.notePreview.NotePreviewService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/admin/v1/notePreview")
@RestController
@Api(tags = {SwaggerConfig.NOTE_PREVIEW_TAG})
public class NotePreviewController {

    private final NotePreviewService notePreviewService;
    private final NotePreviewMapper notePreviewMapper;

    @PostMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public NotePreviewResponse createNotePreview(@RequestBody NotePreviewRequest notePreviewRequest) {
        return notePreviewMapper.toResponse(
            notePreviewService.createNotePreview(
                notePreviewMapper.fromRequest(notePreviewRequest)
            )
        );
    }

    @GetMapping(value = "/{notePreviewId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NotePreviewResponse getNotePreviewId(@PathVariable long notePreviewId) throws NoteNotFoundException {
        return notePreviewMapper.toResponse(
            notePreviewService.getNotePreviewById(notePreviewId)
        );
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NotePreviewResponse> getNotePreviews() {
        return notePreviewService.getNotePreviews().stream()
            .map(notePreviewMapper::toResponse)
            .collect(Collectors.toList());
    }

    @PutMapping(value = "/{notePreviewId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NotePreviewResponse updateNotePreview(@PathVariable long notePreviewId, @RequestBody NotePreviewRequest notePreviewRequest) throws  NoteNotFoundException {
        return notePreviewMapper.toResponse(
            notePreviewService.updateNotePreview(
                notePreviewMapper.fromRequest(notePreviewRequest, notePreviewId)
            )
        );
    }

    @DeleteMapping(value = "/{notePreviewId}")
    public void deleteNotePreview(@PathVariable long notePreviewId) {
        notePreviewService.deleteNotePreview(notePreviewId);
    }
}
