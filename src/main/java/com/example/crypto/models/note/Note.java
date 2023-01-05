package com.example.crypto.models.note;

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
public class Note {

    private long id;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @NotNull
    private String keyword;

}
