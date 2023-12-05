package dev.lugus.user.application.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class UserResponseDTO<T> {

    private ZonedDateTime timestamp;
    private Boolean success;
    private T data;

}
