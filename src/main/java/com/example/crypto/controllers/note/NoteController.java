package com.example.crypto.controllers.note;

import com.example.crypto.config.SwaggerConfig;
import com.example.crypto.exceptions.note.NoteNotFoundException;
import com.example.crypto.mappers.note.NoteMapper;
import com.example.crypto.models.note.NoteRequest;
import com.example.crypto.models.note.NoteResponse;
import com.example.crypto.sevices.note.NoteService;
import io.swagger.annotations.Api;
import liquibase.pro.packaged.S;
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
@RequestMapping("/api/admin/v1/note")
@RestController
@Api(tags = {SwaggerConfig.NOTE_TAG})
public class NoteController {

    private final NoteService noteService;
    private final NoteMapper noteMapper;

    /**
     * Returns created note.
     *
     * @param noteRequest specifies a data for creating a note
     * @return created note
     */
    @PostMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse createNote(@RequestBody NoteRequest noteRequest) {
        return noteMapper.toResponse(
            noteService.createNote(
                noteMapper.fromRequest(noteRequest)
            )
        );
    }

    @PostMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse createLinkedNote(@PathVariable long userId, @RequestBody NoteRequest noteRequest) {
        return noteMapper.toResponse(
            noteService.createLinkedNote(
                noteMapper.fromRequest(noteRequest), userId
            )
        );
    }

    /**
     * Returns a note for requested an identifier of a note
     *
     * @param noteId specifies an identifier of a note
     * @return a note for requested an identifier of note
     * @throws NoteNotFoundException when note not found
     */
    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse getNoteById(@PathVariable long noteId) throws NoteNotFoundException {
        return noteMapper.toResponse(
            noteService.getNoteById(noteId)
        );
    }

    @GetMapping(value = "/{noteId}/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse getNoteByIdAndKeyword(@PathVariable long noteId, @PathVariable String keyword) throws NoteNotFoundException {
        return noteMapper.toResponse(
            noteService.getNoteByIdAndKeyword(noteId, keyword)
        );
    }

    /**
     * Returns a list of all notes
     *
     * @return a list of all notes
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteResponse> getNotes() {
        return noteService.getNotes()
            .stream()
            .map(noteMapper::toResponse)
            .collect(Collectors.toList());
    }

    /**
     * Returns updated note
     *
     * @param noteId specifies an identifier of a note
     * @param noteRequest specifies a data for updating note
     * @return updated note
     * @throws NoteNotFoundException when note not found
     */
    @PutMapping(value = "/{noteId}/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse updateNote(@PathVariable long noteId, @PathVariable String keyword, @RequestBody NoteRequest noteRequest) throws NoteNotFoundException {
        return noteMapper.toResponse(
            noteService.updateNote(
                noteMapper.fromRequest(noteRequest, noteId), keyword
            )
        );
    }

    /**
     * Removes a note for requested an identifier of a note
     *
     * @param noteId specifies an identifier of a note
     */
    @DeleteMapping(value = "/{noteId}")
    public void deleteNote(@PathVariable long noteId) {
        noteService.deleteNote(noteId);
    }
}
