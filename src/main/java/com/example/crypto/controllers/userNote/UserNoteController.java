package com.example.crypto.controllers.userNote;

import com.example.crypto.config.SwaggerConfig;
import com.example.crypto.exceptions.user.UserNotFoundException;
import com.example.crypto.exceptions.userNote.UserNoteNotFoundException;
import com.example.crypto.mappers.userNote.UserNoteMapper;
import com.example.crypto.models.userNote.UserNoteRequest;
import com.example.crypto.models.userNote.UserNoteResponse;
import com.example.crypto.sevices.userNote.UserNoteService;
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
@RequestMapping("/api/admin/v1/userNote")
@RestController
@Api(tags = {SwaggerConfig.USER_NOTE_TAG})
public class UserNoteController {

    private final UserNoteService userNoteService;
    private final UserNoteMapper userNoteMapper;

    @PostMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserNoteResponse createUserNote(@RequestBody UserNoteRequest userNoteRequest) {
        return userNoteMapper.toResponse(
            userNoteService.createUserNote(
                userNoteMapper.fromRequest(userNoteRequest)
            )
        );
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserNoteResponse> getUserNotes(){
        return  userNoteService.getUserNotes().stream()
            .map(userNoteMapper::toResponse)
            .collect(Collectors.toList());
    }

    @GetMapping(value = "/{userNoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserNoteResponse getUserNoteById(@PathVariable long userNoteId) throws UserNoteNotFoundException {
        return userNoteMapper.toResponse(
            userNoteService.getUserNoteById(userNoteId)
        );
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserNoteResponse>  getUserNotesByUserId(@PathVariable long userId) throws UserNoteNotFoundException, UserNotFoundException {
        return userNoteService.getUserNotesByUserId(userId).stream()
            .map(userNoteMapper::toResponse)
            .collect(Collectors.toList());
    }

    @PutMapping(value = "/{userNoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserNoteResponse updateUserNote(@PathVariable long userNoteId, @RequestBody UserNoteRequest userNoteRequest) throws UserNoteNotFoundException {
        return  userNoteMapper.toResponse(
            userNoteService.updateUserNote(
                userNoteMapper.fromRequest(userNoteRequest, userNoteId)
            )
        );
    }

    @DeleteMapping(value = "/{userNoteId}")
    public void deleteUserNote(@PathVariable long userNoteId){
        userNoteService.deleteUserNote(userNoteId);
    }
}
