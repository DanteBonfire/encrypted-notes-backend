package com.example.crypto.models.userNote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserNote {

    private long id;

    @NotNull
    private long userId;

    @NotNull
    private long noteId;

    @NotNull
    private UserNoteAccess access;

}
